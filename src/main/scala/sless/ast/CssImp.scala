package sless.ast

case class CssImp(rules: Seq[RuleImp]) extends CompilableImp {

  override def compileDebug(): String =
    "<CSS: " + rules.foldRight("")((a, b) => a.compileDebug() + b) + ">"

  override def compile(): String = rules.foldRight("")((a, b) => a.compile() + b)

  override def prettyPrint(indent: Int): String = rules.foldRight("")((a, b) => a.prettyPrint(indent) + (if (b == "") "" else "\n\n") + b)
}
