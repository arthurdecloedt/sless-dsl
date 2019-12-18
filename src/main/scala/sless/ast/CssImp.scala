package sless.ast

case class CssImp(rules: Seq[RuleImp]) extends CompilableDebugImp {

  override def compileDebug(): String =
    "<CSS: " + rules.foldRight("")((a, b) => a.compileDebug() + b) + ">"


}
