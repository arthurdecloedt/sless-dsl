package sless.ast.selectors

import sless.ast.SelectorImp

class SelectorUnary(selector: SelectorImp, string: String) extends SelectorImp {
  override def compileDebug(): String = "<Selector " + debugName + ": " + selector.compileDebug() + " : " + string + ">"
}
