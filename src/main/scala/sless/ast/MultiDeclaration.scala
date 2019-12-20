package sless.ast

case class MultiDeclaration(declarations: Seq[DeclarationImp], comment: String = null) extends DeclarationImp {
  override def compileDebug(): String =
    "<Multidec: " + declarations.foldRight("")((a, b) => a.compileDebug() + b) + ">"

  override def compile(): String = if (hasComment) declarations.foldRight("")((a, b) => a.compile() + b) + "/* " + comment + " */" else declarations.foldRight("")((a, b) => a.compile() + b)

  def hasComment: Boolean = comment != null

  override def prettyPrint(indent: Int): String = if (!hasComment) declarations.foldLeft("")((a, b) => a + b.prettyPrint(indent))
  else declarations.foldLeft("")((a, b) => a + b.prettyPrint(indent)) + "; /* " + comment + " */"

  def notEmpty(): Boolean = declarations.nonEmpty && declarations.foldRight(false)((a, b) => a.notEmpty() || b)

  override def condense(): DeclarationImp =
    replace(getFirst.get, MonoDeclaration(PropertyImp("margin"), ValueImp(marginVals))).removeMargins.get

  def marginVals: String = margins.map(a => this.collect(a).get).reduce(_ + " " + _)

  override def collect(prop: String): Option[String] = declarations.view.flatMap(a => a.collect(prop)).headOption

  override def getFirst: Option[DeclarationImp] = declarations.view.flatMap(a => a.getFirst).headOption

  override def replace(orig: DeclarationImp, repl: DeclarationImp): DeclarationImp =
    MultiDeclaration(declarations.map(a => a.replace(orig, repl)))

  override def allMargins(): Boolean = margins.foldRight(true)((a, b) => this.hasProp(a) && b)

  override def hasProp(prop: String): Boolean = declarations.foldRight(false)((a, b) => a.hasProp(prop) || b)

  override def removeMargins: Option[DeclarationImp] = Some(MultiDeclaration(declarations.flatMap(a => a.removeMargins)))

  override def aggrProp(prop: String): Int = declarations.foldRight(0)((a, b) => a.aggrProp(prop) + b)

  override def addComment(comment: String): DeclarationImp = MultiDeclaration(declarations, comment)


}

