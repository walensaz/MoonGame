package scala.me.zach.managers

import java.util.concurrent.{Executors, ScheduledExecutorService}

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


}
