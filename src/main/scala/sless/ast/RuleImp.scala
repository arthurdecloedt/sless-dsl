package sless.ast

case class RuleImp(selector: SelectorImp, declaration: DeclarationImp) extends CompilableImp {
  override def compileDebug(): String = "<Rule: " + selector.compileDebug() + " : " + declaration.compileDebug() + ">"

  override def compile(): String = selector.compile() + "{" + declaration.compile() + "}"

  override def prettyPrint(indent: Int): String = selector.prettyPrint(indent) + " {\n" + declaration.prettyPrint(indent) + "}"
}
