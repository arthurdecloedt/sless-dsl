package sless.ast

class SelectorImp() extends CompilableDebugImp {
  override def compileDebug(): String = "<Selector " + debugName + ">"

  val debugName: String = "sel base"
}
