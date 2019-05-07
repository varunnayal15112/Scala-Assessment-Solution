package services

import models.VendingMachine
import utils.{ConfirmationType, GenericMathsOperation}

case class Customer(vendingMachine: VendingMachine) {

  private val mapOfItemsAndTheirPrice = vendingMachine.getMapOfItemsAndTheirPrice()

  def showItemsDashBoardWithTheirPrices() = {
    for((item,price) <- mapOfItemsAndTheirPrice) {
      println("Item Name : " + item + "\t" + "Item Price : " + price)
    }
    true
  }

  def getPriceOfSelectedItem(selectedItem : String): Int = {
    mapOfItemsAndTheirPrice(selectedItem)
  }

  def provideRequestedItemsWithChange(coinsMap:Map[Int,Int],
                                      notesMap:Map[Int,Int],
                                      requestedItemsMap:Map[String,Int],confirmation : ConfirmationType.Value) : Boolean = {

    val status = confirmation.toString match {
      case "YES" => true
      case "NO" => false
    }

    if(status==false)
      {
        println("Whole Amount Submitted By User Refunded as User Cancelled the Request !!!")
        false
      }


    var totalSumSubmittedByUser = 0
    for((coin,count) <- coinsMap) {
      totalSumSubmittedByUser += GenericMathsOperation.genericMathsOperation(coin,count,(x,y)=>(x*y))
      vendingMachine.addNewCoins(coin,count)
    }
    for((note,count) <- notesMap) {
      totalSumSubmittedByUser += GenericMathsOperation.genericMathsOperation(note,count,(x,y)=>(x*y))
      vendingMachine.addNewNotes(note,count)
    }
    var totalAmountToBePaidByUser = 0
    for((item,quantity) <- requestedItemsMap) {
      totalAmountToBePaidByUser += GenericMathsOperation.genericMathsOperation(mapOfItemsAndTheirPrice(item),quantity,(x,y)=>(x*y))
    }
    var changeAmount = GenericMathsOperation.genericMathsOperation(totalSumSubmittedByUser,totalAmountToBePaidByUser,(x,y)=>(x-y))

    changeAmount match {
      case x if x==0 => println("Requested Items Dispatched with no change")
                        true
      case x if x>0 => println("Requested Items Dispatched with " + x + " amount change")
        // method to deduct denominations from balance of vending machine to provide change to user
                       true
    }
  }
}
