package scalaserver.event

trait EventExecutor {
  val eventName: String
  def execute(event: Event): Unit
}

object EventExecutor {
  type Id = String
}
