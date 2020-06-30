package scalaserver.event

trait EventExecutor {
  type Name
  val eventName: String
  def execute(eventPayload: Event): Unit
}

object EventExecutor {
  type nameId = String
}
