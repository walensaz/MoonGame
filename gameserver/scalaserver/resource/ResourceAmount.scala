package scalaserver.resource

case class ResourceAmount(amount: Int) {

  def addResource(amount: Int): Unit = {
    this.amount += amount
  }

  def removeResource(amount: Int): Unit ={
    this.amount -= amount
  }

}
