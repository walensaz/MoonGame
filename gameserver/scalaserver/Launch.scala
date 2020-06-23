package scalaserver

import scala.language.postfixOps

object Launch extends App {
  BaseModule.registerAllEvents()
  BaseModule.registerAllPackets()
  BaseModule.registerListeners()
  BaseModule.registerResources()




  

}
