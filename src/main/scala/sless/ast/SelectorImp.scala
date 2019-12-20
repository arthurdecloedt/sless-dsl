package sless.ast

class SelectorImp() extends CompilableImp {
  val op: String = ""
  val prettyOp: String = op
  val debugName: String = "sel base"

  override def compileDebug(): String = "<Selector " + debugName + ">"
}
