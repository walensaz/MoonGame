package scalaserver.entity

trait Listener extends Runnable {
  val name: String
  def run(): Unit
}
