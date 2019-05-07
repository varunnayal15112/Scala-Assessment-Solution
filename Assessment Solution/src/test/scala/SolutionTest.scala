import models.VendingMachine
import org.scalatest.FunSuite

class SolutionTest extends FunSuite{

  val vendingMachineObject = new VendingMachine(List(),List(),List())

  test("VendingMachine.addNewItems") {
    assert(vendingMachineObject.addNewItems("Chips",10) === true)
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
    val item: String = "NotExist"
    assert(vendingMachineObject.getPriceOfItem(item) === -1)
  }

  test("VendingMachine.printMapOfItemsAndTheirPrice") {
    assert(vendingMachineObject.printMapOfItemsAndTheirPrice() === true)
  }
}
