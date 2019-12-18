package sless.ast

case class PropertyImp(property: String) extends CompilableImp {
  override def compileDebug(): String = "<Property: " + property + ">"

  override def compile(): String = property
}
