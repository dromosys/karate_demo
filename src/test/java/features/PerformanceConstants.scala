package util

object PerformanceConstants {
  def numOfUsers = 5

  def duration = 30 // in seconds

//  def duration = 8*3600 // 8 hrs

  def secondMillis = 1000
  val (mean, percentile_75, percentile_95) = {  ( ( 8.2* secondMillis).toInt,   ( 8.5* secondMillis).toInt,  ( 8.4* secondMillis).toInt) }

  def usersForTPS(tps: Int, avgResponseTime: Int): Int = {
    (tps * avgResponseTime / secondMillis).toInt
  }
}