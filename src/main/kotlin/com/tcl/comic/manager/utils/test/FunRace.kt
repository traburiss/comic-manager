package com.tcl.comic.manager.utils.test

import org.apache.commons.lang3.time.DurationFormatUtils
import java.text.NumberFormat
import java.util.concurrent.ConcurrentHashMap

/**
 * 函数比赛
 */
@Suppress("unused")
class FunRace {
    var athletes = ArrayList<Athlete>()
    fun athletesEnter(athlete: Athlete):FunRace{
        athletes.add(athlete)
        return this
    }
    fun play():String{
        for (athlete in athletes){
            StopWatch.start(athlete.name)
            for (i in 0..athlete.playTimes){
                athlete.function(athlete.name)
            }
            StopWatch.stop(athlete.name)
        }
        return StopWatch.showTime()
    }

    object StopWatch{
        private var numberFormat = NumberFormat.getInstance()
        private val watch = ConcurrentHashMap<String, SecondHand>()
        init {
            numberFormat.maximumFractionDigits = 2
        }
        fun start(name: String){
            watch[name] = SecondHand()
        }
        
        fun stop(name: String){
            watch.compute(name) { _, V ->
                if (V != null) {
                    V.isRun = false
                    V.time = System.currentTimeMillis() - V.time
                }
                V
            }
        }
        
        fun showTime(formatter: String="HH:mm:ss.SSS"): String{
            var show = String.format("%-10s", "名称") + String.format("%-20s", "时间") + String.format("%-10s", "占比") + "\n"
            var total = 0L
            for ((_ , secondHand) in watch){
                if (!secondHand.isRun){
                    total += secondHand.time
                }
            }
            for ((name , secondHand) in watch){
                if (!secondHand.isRun){
                    val percent = if (total == 0L) "∞" else numberFormat.format(secondHand.time.toDouble()/total.toDouble()*100) + "%"
                    show += String.format("%-10s", name) + 
                            String.format("%-20s", DurationFormatUtils.formatDuration(secondHand.time, formatter)) + 
                            String.format("%-10s", percent) + "\n"
                }
            }
            return show
        }
    }

    data class SecondHand(var time:Long=System.currentTimeMillis(), var isRun:Boolean=true)
    data class Athlete(val name: String, val function: (String) -> Unit, val playTimes: Int = 1)
}
