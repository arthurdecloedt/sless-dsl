package sless.ast.selectors

import sless.ast.SelectorImp

case class TypeSelector(string: String) extends SelectorImp {
  override val debugName: String = "Type"

  override def compileDebug(): String = "<Selector " + debugName + " : " + string + ">"

  override def compile(): String = string
}
