package com.tcl.comic.manager.utils.test

import org.apache.commons.lang3.time.DurationFormatUtils
import org.apache.commons.lang3.time.FastDateFormat
import java.text.NumberFormat
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.CountDownLatch
import java.util.concurrent.CyclicBarrier
import java.util.concurrent.Executors
import java.util.concurrent.atomic.AtomicBoolean

/**
 * 函数赛跑
 */
class FunRace {
    
    var athletes = ArrayList<Athlete>()
    
    fun athletesEnter(athlete: Athlete):FunRace{
        athletes.add(athlete)
        return this
    }
    
    fun start(trackNum: Int=-1, liveSignal: (String) -> Unit={}, live: Boolean=true):String{
        val stopWatch = Stopwatch()
        var replay = ""
        val ready = CyclicBarrier(athletes.size)
        val finishLine = CountDownLatch(athletes.size)
        val track = if (trackNum == -1) {
            if (live){
                liveSignal("ATTENTION YOUR C P U")
            }
            Executors.newCachedThreadPool()
        } else {
            Executors.newFixedThreadPool(trackNum)
        }
        if (live){
            Thread.sleep(1000)
            liveSignal("three")
            Thread.sleep(1000)
            liveSignal("two")
            Thread.sleep(1000)
            liveSignal("one")
            Thread.sleep(1000)
            liveSignal("走着")
        }
        for (athlete in athletes){
            track.execute {
                if (trackNum == -1) {
                    ready.await()
                }
                stopWatch.start(athlete.name)
                for (i in 0 until athlete.times){
                    athlete.function(athlete.name)
                }
                val picture = stopWatch.stop(athlete.name)
                replay += "$picture\n"
                if (live){
                    liveSignal(picture)
                }
                finishLine.countDown()
            }
        }
        track.shutdown()
        finishLine.await()
        val picture = stopWatch.showTime()
        replay += "$picture\n"
        if (live){
            liveSignal("结果是\n $picture")
        }
        return replay
    }

    class Stopwatch(formatter: String = "yyyy-MM-dd HH:mm:ss.SSS") {
        private val dateFormat: FastDateFormat = FastDateFormat.getInstance(formatter)
        private var watch = ConcurrentHashMap<String, SecondHand>()

        fun start(name: String){
            watch[name] = SecondHand()
        }
        
        fun stop(name: String, formatter: String="mm:ss.SSS"): String{
            watch[name]?.stop()
            return String.format("%-10s", name) + dateFormat.format(System.currentTimeMillis()) + "冲线！-> " + String.format("%-20s", watch[name]!!.duration(formatter))
        }
        
        fun showTime(durationFormatter: String="mm:ss.SSS"): String{
            var show = format("名字", "用时", "占比") + "\n"
            var total = 0L
            for ((_ , secondHand) in watch){
                if (secondHand.isEnd.get()){
                    total += secondHand.time
                }
            }
            for ((name , secondHand) in watch){
                if (secondHand.isEnd.get()){
                    show += format(name, secondHand.duration(durationFormatter), secondHand.percent(total))
                }
            }
            return show
        }
        
        private fun format(name: String, duration: String, percent: String): String{
            return String.format("%-10s", name) + String.format("%-20s", duration) + String.format("%-10s", percent) + "\n"
        }
    }

    data class SecondHand(var time:Long=System.currentTimeMillis(), var isEnd:AtomicBoolean=AtomicBoolean(false)){
        private val numberFormat = NumberFormat.getInstance();
        init {
            numberFormat.maximumFractionDigits = 2
        }
        
        fun stop(){
            if (isEnd.compareAndSet(false, true)){
                time = System.currentTimeMillis() - time
            }
        }
        
        fun duration(formatter: String="mm:ss.SSS"): String{
            return if (isEnd.get()){
                DurationFormatUtils.formatDuration(time, formatter)
            }else{
                "is running"
            }
        }
        
        fun percent(total: Long):String{
            return if (isEnd.get()){
                if (total == 0L){
                    "∞"
                }else{
                    numberFormat.format(time.toDouble()/total.toDouble() * 100) + "%"
                }
            }else{
                "is running"
            }
        }
    }
    data class Athlete(val name: String, val function: (String) -> Unit, val times: Int = 1)
}
