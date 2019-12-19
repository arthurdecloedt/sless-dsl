package sless.ast

case class RuleImp(selector: SelectorImp, declaration: DeclarationImp, comment: String = null) extends CompilableImp {
  def condense(): RuleImp = RuleImp(selector, declaration.condense())

  def allMargins(): Boolean = declaration.allMargins()

  def notEmpty(): Boolean = declaration.notEmpty()

  def aggrProp(prop: String): Int = declaration.aggrProp(prop)

  override def compile(): String = if (!hasComment) (selector.compile() + "{" + declaration.compile() + "}") else "/* " + comment + " */" + selector.compile() + "{" + declaration.compile() + "}"

  override def compileDebug(): String = "<Rule: " + selector.compileDebug() + " : " + declaration.compileDebug() + ">"

  override def prettyPrint(indent: Int): String = if (!hasComment) selector.prettyPrint(indent) + " {\n" + declaration.prettyPrint(indent) + "}"
  else "/* " + comment + " */\n" + selector.prettyPrint(indent) + " {\n" + declaration.prettyPrint(indent) + "}"

  def hasComment: Boolean = comment != null

  def addComment(comment: String): RuleImp = RuleImp(selector, declaration, comment)

}
