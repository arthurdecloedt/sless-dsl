package sless.ast.selectors

import sless.ast.SelectorImp

case class AdjacentSelector(s1: SelectorImp, s2: SelectorImp) extends SelectorBinary(s1, s2) {
  override val debugName: String = "Adj"
}



