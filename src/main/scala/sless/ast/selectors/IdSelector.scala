package sless.ast.selectors

import sless.ast.SelectorImp

case class IdSelector(selector: SelectorImp, string: String) extends SelectorUnary(selector, string) {

  override val debugName: String = "ID"

  override val op: String = "#"

  override val prettyOp: String = "#"
}

