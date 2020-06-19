package scala.me.zach

import scala.concurrent.{ExecutionContext, Future}
import scala.language.postfixOps
import scala.me.zach.Database.Statement

object Launch extends App {

  AsyncManager.runAsync(Any => Database.getFromDataBase(query = Statement("SELECT * FROM test")))

  Thread.sleep(10000)

}
