package scalaserver.managers

import java.util.concurrent.{Executors, ScheduledExecutorService, TimeUnit}

import scalaserver.Config.ServerConfig
import scalaserver.server.Listener

import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success}

object AsyncManager {

  private implicit val ec: ExecutionContext = ExecutionContext.global

  val scheduler: ScheduledExecutorService = Executors.newScheduledThreadPool(300)

  def runAsync(function: Any => Any): Future[Any] = {
    Future {
      println("Running async " + function.toString())
      function
    }
  }


  def runAsyncWithCallback(function: Any => Any, callback: Any => Any): Unit = {
    val future: Future[Any] = Future {
      function
    }

    future onComplete {
      case Success(value) => callback(value)
      case Failure(exception) => println(exception.getMessage)
    }
  }

  def registerListener(newListener: Listener): Unit = {
    scheduler.scheduleAtFixedRate(newListener, 100L, ServerConfig.TICK_RATE, TimeUnit.MILLISECONDS)
  }


}
