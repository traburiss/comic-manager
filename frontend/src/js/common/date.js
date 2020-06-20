/**
 * "" ==> 2006-07-02 08:09:04
 * "yyyy-MM-dd hh:mm:ss.S" ==> 2006-07-02 08:09:04.423
 * "yyyy-M-d h:m:s.S" ==> 2006-7-2 8:9:4.18
 */
export function formatTimestamp(timestamp, fmt) {
  if (timestamp !== null && timestamp !== undefined) {
    return formatDate(new Date(timestamp), fmt)
  } else {
    return '未设置时间'
  }
}

/**
 * "" ==> 2006-07-02 08:09:04
 * "yyyy-MM-dd hh:mm:ss.S" ==> 2006-07-02 08:09:04.423
 * "yyyy-M-d h:m:s.S" ==> 2006-7-2 8:9:4.18
 */
export function formatDate(date, fmt) {
  let ret;
  if (fmt === null || fmt === undefined || fmt === '') {
    fmt = 'yyyy-MM-dd hh:mm:ss'
  }
  const opt = {
    "y+": date.getFullYear().toString(),        // 年
    "M+": (date.getMonth() + 1).toString(),     // 月
    "d+": date.getDate().toString(),            // 日
    "h+": date.getHours().toString(),           // 时
    "m+": date.getMinutes().toString(),         // 分
    "s+": date.getSeconds().toString(),          // 秒
    "S+": date.getMilliseconds().toString()          // 毫秒
    // 有其他格式化字符需求可以继续添加，必须转化成字符串
  };
  for (let k in opt) {
    ret = new RegExp("(" + k + ")").exec(fmt);
    if (ret) {
      fmt = fmt.replace(ret[1], (ret[1].length === 1) ? (opt[k]) : (opt[k].padStart(ret[1].length, "0")))
    }
  }
  return fmt;
}
