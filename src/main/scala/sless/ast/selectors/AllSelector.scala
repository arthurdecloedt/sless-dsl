package sless.ast.selectors

import sless.ast.SelectorImp

case class AllSelector() extends SelectorImp {
  override val debugName: String = "Adj"

  override def compile(): String = "*"
}
