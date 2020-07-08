package scalaserver

import java.text.{DateFormat, SimpleDateFormat}
import java.util.Date

object Logger {

  val ANSI_RESET = "\u001B[0m"
  val ANSI_BLACK = "\u001B[30m"
  val ANSI_RED = "\u001B[31m"
  val ANSI_GREEN = "\u001B[32m"
  val ANSI_YELLOW = "\u001B[33m"
  val ANSI_BLUE = "\u001B[34m"
  val ANSI_PURPLE = "\u001B[35m"
  val ANSI_CYAN = "\u001B[36m"
  val ANSI_WHITE = "\u001B[37m"

  implicit val dataFormat: DateFormat = new SimpleDateFormat("[MM/dd/yyyy-hh:mm:ss]")

  def notify(notification: String): Unit = {
    println(s"$ANSI_BLUE[NOTIFY]${dataFormat.format(new Date(System.currentTimeMillis()))} $notification")
  }

  def log(log: String): Unit = {
    println(s"$ANSI_PURPLE[LOG]${dataFormat.format(new Date(System.currentTimeMillis()))} - $log")
  }

  def info(info: String): Unit = {
    println(s"$ANSI_YELLOW[INFO]${dataFormat.format(new Date(System.currentTimeMillis()))} $info")
  }

  def error(error: String, clazz: Class[Any]): Unit = {
    println(s"$ANSI_RED${clazz.getCanonicalName} >> $error")
  }

  def error(error: String): Unit = {
    println(s"$ANSI_RED[ERROR]${dataFormat.format(new Date(System.currentTimeMillis()))} >> $error")
  }

}
