package sless.ast

case class PropertyImp(property: String) extends CompilableDebugImp {
  override def compileDebug(): String = "<Property: " + property + ">"
}
