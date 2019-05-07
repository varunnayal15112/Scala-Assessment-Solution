package services

import models.VendingMachine

case class Customer(vendingMachine: VendingMachine) {

  private val mapOfItemsAndTheirPrice = vendingMachine.getMapOfItemsAndTheirPrice()

  def showItemsDashBoardWithTheirPrices() = {
    for((item,price) <- mapOfItemsAndTheirPrice) {
      println("Item Name : " + item + "\t" + "Item Price : " + price)
    }
    true
  }

  def getPriceOfSelectedItem(selectedItem : String): Int = {
    vendingMachine.getPriceOfItem(selectedItem)
  }
}
