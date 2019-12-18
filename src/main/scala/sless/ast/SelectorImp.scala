package sless.ast

class SelectorImp() extends CompilableImp {
  override def compileDebug(): String = "<Selector " + debugName + ">"

  val op: String = ""
  val prettyOp: String = op
  val debugName: String = "sel base"
}
