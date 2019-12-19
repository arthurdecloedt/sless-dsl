package sless.ast

case class MonoDeclaration(property: PropertyImp, value: ValueImp) extends DeclarationImp {

  override def condense(): DeclarationImp = this

  override def allMargins(): Boolean = false

  override def compileDebug(): String = "<Declaration: " + property.compileDebug() + " : " + value.compileDebug() + ">"

  override def compile(): String = property.compile() + ":" + value.compile() + ";"

  override def prettyPrint(indent: Int): String = " " * indent + property.prettyPrint(indent) + ": " + value.prettyPrint(indent) + ";\n"

  def notEmpty(): Boolean = property.property != "" && value.value != ""

  override def hasProp(prop: String): Boolean = prop == property.property

  override def getFirst: Option[DeclarationImp] = if (margins.contains(property.property)) Some(this) else None

  override def collect(prop: String): Option[String] = if (property.property == prop) Some(value.value) else None

  override def removeMargins: Option[DeclarationImp] =
    if (margins.contains(property.property)) None else Some(this)

  override def replace(orig: DeclarationImp, repl: DeclarationImp): DeclarationImp = if (this.equals(orig)) repl else this

  override def aggrProp(prop: String): Int = if (property.property == prop) 1 else 0
}
