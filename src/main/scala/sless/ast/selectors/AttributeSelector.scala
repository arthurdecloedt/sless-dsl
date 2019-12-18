package sless.ast.selectors

import sless.ast.{SelectorImp, ValueImp}

case class AttributeSelector(selector: SelectorImp, string: String, value: ValueImp) extends SelectorImp {
  override val debugName: String = "attr"

}
