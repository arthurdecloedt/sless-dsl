package sless.ast

case class RuleImp(selector: SelectorImp, declaration: DeclarationImp) extends CompilableImp {
  def condense(): RuleImp = RuleImp(selector, declaration.condense())

  def allMargins(): Boolean = declaration.allMargins()

  def notEmpty(): Boolean = declaration.notEmpty()

  def aggrProp(prop: String) = declaration.aggrProp(prop)

  override def compileDebug(): String = "<Rule: " + selector.compileDebug() + " : " + declaration.compileDebug() + ">"

  override def compile(): String = selector.compile() + "{" + declaration.compile() + "}"

  override def prettyPrint(indent: Int): String = selector.prettyPrint(indent) + " {\n" + declaration.prettyPrint(indent) + "}"


}
