package sless.ast

case class MonoDeclaration(property: PropertyImp, value: ValueImp) extends DeclarationImp {

  override def compileDebug(): String = "<Declaration: " + property.compileDebug() + " : " + value.compileDebug() + ">"

}
