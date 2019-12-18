package sless.ast

case class RuleImp(selector: SelectorImp, declaration: DeclarationImp) extends CompilableDebugImp {
  override def compileDebug(): String = "<Rule: " + selector.compileDebug() + " : " + declaration.compileDebug() + ">"

}
