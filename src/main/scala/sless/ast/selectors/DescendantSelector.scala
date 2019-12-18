package sless.ast.selectors

import sless.ast.SelectorImp

case class DescendantSelector(s1: SelectorImp, s2: SelectorImp) extends SelectorBinary(s1, s2) {
  override val debugName: String = "Desc"

  override val op: String = " "
  override val prettyOp: String = " "
}
