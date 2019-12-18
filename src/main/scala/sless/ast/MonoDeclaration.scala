package sless.ast

case class MonoDeclaration(property: PropertyImp, value: ValueImp) extends DeclarationImp {

  override def compileDebug(): String = "<Declaration: " + property.compileDebug() + " : " + value.compileDebug() + ">"

  override def compile(): String = property.compile() + ":" + value.compile() + ";"

  override def prettyPrint(indent: Int): String = " " * indent + property.prettyPrint(indent) + ": " + value.prettyPrint(indent) + ";\n"
}
