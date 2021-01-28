package scalaserver.objects

import scalaserver.Logger

class Chance[T](valueWithChance: Map[T, Double]) {

  lazy val remainder = 100 - valueWithChance.values.sum

  def generateRandom(): Option[T] = {
    if(remainder < 0) {
      Logger.error("The chance of values can't be above 100")
      None
    } else {
      //val ranges = valueWithChance.map()
      val randomChance = Math.random() * 100
      None
    }
  }

}
