package sless.ast.selectors

import sless.ast.SelectorImp

class SelectorBinary(selector1: SelectorImp, selector2: SelectorImp) extends SelectorImp {
  override val prettyOp: String = " " + op + " "

  override def compileDebug(): String = "<Selector " + debugName + ": " + selector1.compileDebug() + " : " + selector2.compileDebug() + ">"

  override def compile(): String = selector1.compile() + op + selector2.compile()

  override def prettyPrint(indent: Int): String = selector1.prettyPrint(indent) + prettyOp + selector2.prettyPrint(indent)

}
