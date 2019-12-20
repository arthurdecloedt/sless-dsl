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

  def hasConflicts: Boolean = rules.exists(_.internalDecClash) || rules.combinations(2).exists(
    (a) => (a.head.seqMatches(a(1)) && a.head.decClash(a(1)))
  )

  def getConflicts: Seq[String] = rules.filter(!_.internalDecClash).combinations(2).filter(
    (a) => (a.head.seqMatches(a(1)) && a.head.decClash(a(1)))
  ).map(a => a.head.compile + " clashes with " + a(1).compile).toSeq
}
