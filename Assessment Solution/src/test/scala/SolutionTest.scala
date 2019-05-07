import models.VendingMachine
import org.scalatest.FunSuite
import services.Customer
import utils.ConfirmationForTransaction
import utils.ConfirmationType.ConfirmationType

class SolutionTest extends FunSuite{

  val vendingMachineObject = new VendingMachine()
  val user1 = new Customer(vendingMachineObject)

  test("VendingMachine.addNewItems") {
    assert(vendingMachineObject.addNewItems("Chips",10) === true)
    assert(vendingMachineObject.addNewItems("Nuts",20) === true)
    assert(vendingMachineObject.addNewItems("Candies",30) === true)
    assert(vendingMachineObject.addNewItems("Biscuits",40) === true)
    assert(vendingMachineObject.addNewItems("ColdDrink",50) === true)
    println(vendingMachineObject.getMapOfItemsAndTheirPrice())
  }

  test("VendingMachine.addNewCoins") {
    assert(vendingMachineObject.addNewCoins(1,1000) === true)
    assert(vendingMachineObject.addNewCoins(2,1000) === true)
    assert(vendingMachineObject.addNewCoins(5,1000) === true)
    assert(vendingMachineObject.addNewCoins(10,1000) === true)
    println(vendingMachineObject.getMapOfCoinsAndTheirCount())
  }

  test("VendingMachine.addNewNotes") {
    assert(vendingMachineObject.addNewNotes(10,1000) === true)
    assert(vendingMachineObject.addNewNotes(20,1000) === true)
    assert(vendingMachineObject.addNewNotes(50,1000) === true)
    assert(vendingMachineObject.addNewNotes(100,1000) === true)
    println(vendingMachineObject.getMapOfNotesAndTheirCount())
  }

  test("VendingMachine.getPriceOfItem -> when item exist in itemList") {
    val item : String = "Chips"
    assert(vendingMachineObject.getPriceOfItem(item) === 10)
  }

  test("VendingMachine.getPriceOfItem -> when item not exist in itemList") {
    val item: String = "NotExist"
    assert(vendingMachineObject.getPriceOfItem(item) === 0)
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

  test("Customer.provideRequestedItemsWithChange") {
    val coinsMap : Map[Int,Int] = Map(1->5,2->5,5->5,10->5)
    val notesMap : Map[Int,Int] = Map(10->5,20->5,50->5,100->5)
    val requestedItemsMap : Map[String,Int] = Map("Chips" -> 2, "Nuts" -> 3, "ColdDrink" -> 5)

    val userConfirmation : ConfirmationType = ConfirmationForTransaction.getConfirmationToProceedTransaction()
    assert(user1.provideRequestedItemsWithChange(coinsMap,notesMap,requestedItemsMap,userConfirmation)===true)

    println(vendingMachineObject.getMapOfCoinsAndTheirCount())
    println(vendingMachineObject.getMapOfNotesAndTheirCount())
  }
}
