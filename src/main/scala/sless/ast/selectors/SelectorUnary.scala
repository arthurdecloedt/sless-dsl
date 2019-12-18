package sless.ast.selectors

import sless.ast.SelectorImp

class SelectorUnary(selector: SelectorImp, string: String) extends SelectorImp {
  override def compileDebug(): String = "<Selector " + debugName + ": " + selector.compileDebug() + " : " + string + ">"

  override def compile(): String = selector.compile() + op + string

  override def prettyPrint(indent: Int): String = selector.prettyPrint(indent) + op + string
}
