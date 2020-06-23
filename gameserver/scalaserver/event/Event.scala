package scalaserver.event

trait Event {

  val eventName: String

  def execute(eventPayload: EventPayload): Unit

}
