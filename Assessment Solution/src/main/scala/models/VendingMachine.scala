package models

case class VendingMachine(private var itemsList:List[String],
                     private var coinsList : List[Int],
                     private var notesList : List[Int]) {

  private var mapOfItemsAndTheirPrice = scala.collection.mutable.Map[String,Int]()

  def printMapOfItemsAndTheirPrice() = {
    println(mapOfItemsAndTheirPrice)
    true
  }

  def addNewItems(item:String,price:Int): Boolean = {
    itemsList ::= item
    mapOfItemsAndTheirPrice += (item -> price)
    true
  }

  def addNewCoins(coin : Int): Boolean= {
    coinsList ::= coin
    true
  }

  def addNewNotes(note :Int):Boolean= {
    notesList ::= note
    true
  }

  def getPriceOfItem(item : String) = {
    if(mapOfItemsAndTheirPrice.contains(item))
      mapOfItemsAndTheirPrice(item)
    else
      -1
  }

  def getItemsList() = {
    itemsList
  }

  def getCoinsList() = {
    coinsList
  }

  def getNotesList() = {
    notesList
  }

  def getMapOfItemsAndTheirPrice() = {
    mapOfItemsAndTheirPrice
  }

  def printItemsList() = {
    println(itemsList)
    true
  }

  def printCoinsList() = {
    println(coinsList)
    true
  }

  def printNotesList() = {
    println(notesList)
    true
  }
}

