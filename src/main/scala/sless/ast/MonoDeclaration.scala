package sless.ast

case class MonoDeclaration(property: PropertyImp, value: ValueImp, comment: String = null) extends DeclarationImp {

  override def condense(): DeclarationImp = this

  override def compile(): String = if (!hasComment) property.compile() + ":" + value.compile() + ";" else property.compile() + ":" + value.compile() + ";" + "/* " + comment + " */"

  def hasComment:
  Boolean = comment != null

  override def allMargins(): Boolean = false

  override def compileDebug(): String = "<Declaration: " + property.compileDebug() + " : " + value.compileDebug() + ">"

  override def prettyPrint(indent: Int): String = if (!hasComment) " " * indent + property.prettyPrint(indent) + ": " + value.prettyPrint(indent) + ";\n"
  else " " * indent + property.prettyPrint(indent) + ": " + value.prettyPrint(indent) + "; /* " + comment + " */\n"

  def notEmpty(): Boolean = property.property != "" && value.value != ""

  override def hasProp(prop: String): Boolean = prop == property.property

  override def getFirst: Option[DeclarationImp] = if (margins.contains(property.property)) Some(this) else None

  override def collect(prop: String): Option[String] = if (property.property == prop) Some(value.value) else None

  override def removeMargins: Option[DeclarationImp] =
    if (margins.contains(property.property)) None else Some(this)

  override def replace(orig: DeclarationImp, repl: DeclarationImp): DeclarationImp = if (this.equals(orig)) repl else this

  override def aggrProp(prop: String): Int = if (property.property == prop) 1 else 0

  override def addComment(comment: String): DeclarationImp = MonoDeclaration(property, value, comment)

}
