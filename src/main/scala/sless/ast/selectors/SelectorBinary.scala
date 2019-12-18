package sless.ast.selectors

import sless.ast.SelectorImp

class SelectorBinary(selector1: SelectorImp, selector2: SelectorImp) extends SelectorImp {
  override def compileDebug(): String = "<Selector " + debugName + ": " + selector1.compileDebug() + " : " + selector2.compileDebug() + ">"


}
