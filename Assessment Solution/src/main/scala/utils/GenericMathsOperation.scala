package utils

object GenericMathsOperation {
  def genericMathsOperation(x:Int,y:Int,definedFunction:(Int,Int)=>Int) :Int = definedFunction(x,y)
}
