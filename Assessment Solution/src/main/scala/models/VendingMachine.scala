package models

case class VendingMachine() {

  private var mapOfItemsAndTheirPrice = scala.collection.mutable.Map[String, Int]()
  private var mapOfCoinsAndTheirCount = scala.collection.mutable.Map[Int, Int](1 -> 0, 2 -> 0, 5 -> 0, 10 -> 0)
  private var mapOfNotesAndTheirCount = scala.collection.mutable.Map[Int, Int](10 -> 0, 20 -> 0, 50 -> 0, 100 -> 0)
  private var totalBalanceOfVendingMachine = 0

  def printMapOfItemsAndTheirPrice() = {
    println(mapOfItemsAndTheirPrice)
    true
  }

  def addNewItems(item: String, price: Int): Boolean = {
    mapOfItemsAndTheirPrice += (item -> price)
    true
  }

  def addNewCoins(coin: Int, numberOfDenominations: Int): Boolean = {
    val currentNumberOfDenominations = mapOfCoinsAndTheirCount(coin)
    mapOfCoinsAndTheirCount += (coin -> (currentNumberOfDenominations + numberOfDenominations))
    totalBalanceOfVendingMachine += coin*numberOfDenominations
    true
  }

  def addNewNotes(note: Int, numberOfDenominations: Int): Boolean = {
    val currentNumberOfDenominations = mapOfNotesAndTheirCount(note)
    mapOfNotesAndTheirCount += (note -> (currentNumberOfDenominations + numberOfDenominations))
    totalBalanceOfVendingMachine += note*numberOfDenominations
    true
  }

  def getPriceOfItem(item: String) = {
    if (mapOfItemsAndTheirPrice.contains(item))
      mapOfItemsAndTheirPrice(item)
    else
      0
  }

  def getMapOfCoinsAndTheirCount() = {
    mapOfCoinsAndTheirCount
  }

  def getMapOfNotesAndTheirCount() = {
    mapOfNotesAndTheirCount
  }

  def getMapOfItemsAndTheirPrice() = {
    mapOfItemsAndTheirPrice
  }
}
