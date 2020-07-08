package scalaserver

object Utils {

  var currentSessionId = 0

  def getNewSessionId = {
    val sessionId = currentSessionId
    currentSessionId = currentSessionId + 1
    sessionId
  }

}
