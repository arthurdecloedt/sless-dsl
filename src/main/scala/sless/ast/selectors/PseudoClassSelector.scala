package sless.ast.selectors

import sless.ast.SelectorImp

case class PseudoClassSelector(selector: SelectorImp, string: String) extends SelectorUnary(selector, string) {
  override val debugName: String = "Pseudo Class"
}
