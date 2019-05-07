import models.VendingMachine
import org.scalatest.FunSuite
import services.Customer

class SolutionTest extends FunSuite{

  val vendingMachineObject = new VendingMachine(List(),List(),List())
  val user1 = new Customer(vendingMachineObject.copy())

  test("VendingMachine.addNewItems") {
    assert(vendingMachineObject.addNewItems("Chips",10) === true)
    assert(vendingMachineObject.addNewItems("Nuts",20) === true)
    assert(vendingMachineObject.addNewItems("Candies",30) === true)
    assert(vendingMachineObject.addNewItems("Biscuits",40) === true)
    assert(vendingMachineObject.addNewItems("ColdDrink",50) === true)
  }

  test("VendingMachine.addNewCoins") {
    assert(vendingMachineObject.addNewCoins(10) === true)
  }

  test("VendingMachine.addNewNotes") {
    assert(vendingMachineObject.addNewNotes(10) === true)
  }

  test("VendingMachine.getPriceOfItem -> when item exist in itemList") {
    val item : String = "Chips"
    assert(vendingMachineObject.getPriceOfItem(item) === 10)
  }

  test("VendingMachine.getPriceOfItem -> when item not exist in itemList") {
    val item: String = "NotExist".toUpperCase
    assert(vendingMachineObject.getPriceOfItem(item) === -1)
  }

  test("VendingMachine.printMapOfItemsAndTheirPrice") {
    assert(vendingMachineObject.printMapOfItemsAndTheirPrice() === true)
  }

  test("Customer.showItemsDashBoardWithTheirPrices") {
    assert(user1.showItemsDashBoardWithTheirPrices() === true)
  }

  test("Customer.getPricesOfSelectedItem") {
    val selectedItem : String = "Chips"
    assert(user1.getPriceOfSelectedItem(selectedItem) === 10)
  }
}
