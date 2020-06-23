package scalaserver.server

trait Listener extends Runnable {
  def run(): Unit
}
