package scala.me.zach

import scala.concurrent.{ExecutionContext, Future}
import scala.language.postfixOps
import scala.me.zach.Database.Statement
import scala.me.zach.managers.AsyncManager

object Launch extends App {

  AsyncManager.runAsync(_ => Database.getFromDataBase(query = Statement("SELECT * FROM test")))

  Thread.sleep(10000)

}
