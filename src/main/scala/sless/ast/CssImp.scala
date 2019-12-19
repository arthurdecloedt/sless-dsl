package sless.ast

case class CssImp(rules: Seq[RuleImp]) extends CompilableImp {

  override def compileDebug(): String =
    "<CSS: " + rules.foldRight("")((a, b) => a.compileDebug() + b) + ">"

  override def compile(): String = rules.foldRight("")((a, b) => a.compile() + b)

  override def prettyPrint(indent: Int): String = rules.foldRight("")((a, b) => a.prettyPrint(indent) + (if (b == "") "" else "\n\n") + b)

  def removeEmptyRules(): (Boolean, CssImp) =
    if (rules.foldRight(true)((a, b) => a.notEmpty() && b))
      (false, this)
    else (true, CssImp(rules.filter(_.notEmpty())))

  def condenseMargins(): (Boolean, CssImp) =
    if (rules.foldRight(true)((a, b) => !a.allMargins() && b))
      (false, this)
    else (true, CssImp(rules.map(a => (if (a.allMargins()) a.condense() else a))))

  def aggrProp(prop: String): Int = rules.foldRight(0)((a, b) => a.aggrProp(prop) + b)

}
