package sless.ast

class SelectorImp() extends CompilableImp {
  lazy val getHashes: Seq[Int] = Seq(this.hashCode())
  val op: String = ""
  val prettyOp: String = op
  val debugName: String = "sel base"

  override def compileDebug(): String = "<Selector " + debugName + ">"
}
