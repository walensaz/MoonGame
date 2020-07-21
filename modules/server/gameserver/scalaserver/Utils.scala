package scalaserver

import java.text.{DateFormat, SimpleDateFormat}
import java.util.Date

object Utils {

  var currentSessionId = 0

  def getNewSessionId = {
    val sessionId = currentSessionId
    currentSessionId = currentSessionId + 1
    sessionId
  }

  def formatDate(date: Date, format: String = "[hh:mm:ss]"): String = {
    val dateFormat: DateFormat = new SimpleDateFormat(format)
    dateFormat.format(date)
  }

}
