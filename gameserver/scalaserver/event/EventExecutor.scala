package scalaserver.event

trait EventExecutor {
  val eventName: String
  def execute(eventPayload: Event): Unit
}
