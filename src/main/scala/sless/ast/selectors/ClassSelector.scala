package sless.ast.selectors

import sless.ast.SelectorImp

case class ClassSelector(selector: SelectorImp, string: String) extends SelectorUnary(selector, string) {
  override val debugName: String = "Class"

}
