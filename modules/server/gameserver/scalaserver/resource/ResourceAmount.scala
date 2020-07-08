package scalaserver.resource

case class ResourceAmount(var amount: Int) {

  def addResource(amount: Int): Unit = {
    this.amount += amount
  }

  def removeResource(amount: Int): Unit ={
    this.amount -= amount
  }
}
