package scalaserver

import java.io.{FileWriter, PrintWriter}
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

  lazy implicit val dateFormat: DateFormat = new SimpleDateFormat("[MM/dd/yyyy-hh:mm:ss]")
  private lazy val loggerFile: PrintWriter = new PrintWriter(new FileWriter(s"${Utils.formatDate(new Date(System.currentTimeMillis()), "MM-dd-yyyy")}-log.log", true))

  def notify(notification: String): Unit = {
    println(s"$ANSI_BLUE[NOTIFY]${dateFormat.format(new Date(System.currentTimeMillis()))} $notification")
  }

  def log(log: String): Unit = {
    val strToPrint = s"[LOG]${dateFormat.format(new Date(System.currentTimeMillis()))} - $log"
    println(s"$ANSI_PURPLE$strToPrint")
    loggerFile.println(strToPrint)
    loggerFile.flush()
  }

  def info(info: String): Unit = {
    println(s"$ANSI_YELLOW[INFO]${dateFormat.format(new Date(System.currentTimeMillis()))} $info")
  }

  def error(error: String, clazz: Class[Any]): Unit = {
    val strToPrint = s"${clazz.getCanonicalName} >> $error"
    println(s"$ANSI_RED$strToPrint")
    loggerFile.println(strToPrint)
    loggerFile.flush()
  }

  def error(error: String): Unit = {
    val strToPrint = s"[ERROR]${dateFormat.format(new Date(System.currentTimeMillis()))} >> $error"
    println(s"$ANSI_RED$strToPrint")
    loggerFile.println(strToPrint)
    loggerFile.flush()
  }

}
