package sless.ast

case class ValueImp(value: String) extends CompilableImp {
  override def compileDebug(): String = "<Value: " + value + ">"

  override def compile(): String = value
}
