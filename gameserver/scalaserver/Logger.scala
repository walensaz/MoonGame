package scalaserver

import java.text.{DateFormat, SimpleDateFormat}
import java.util.Date

object Logger {

  implicit val dataFormat: DateFormat = new SimpleDateFormat("[MM/dd/yyyy-hh:mm:ss]")

  def log(info: String): Unit = {
    println(s"${dataFormat.format(new Date(System.currentTimeMillis()))} > $info")
  }

  def error(error: String, clazz: Class[Any]): Unit = {
    println(s"\u001B[31m ${clazz.getCanonicalName} >> $error")
  }



}
