package sless.ast

case class ValueImp(value: String) extends CompilableDebugImp {
  override def compileDebug(): String = "<Value: " + value + ">"
}
