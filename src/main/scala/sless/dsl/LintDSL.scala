package sless.dsl

/**
  * All Lint checks you implement in this file are of a similar form: they accept a CSS sheet,
  * check a particular boolean condition, and return a pair consisting of a Boolean and a fixed sheet
  *  (only in case the boolean is true, otherwise the original sheet is returned).
  *  A sheet is only returned if the code mistake can be fixed automatically.
  * */

trait LintDSL extends BaseDSL {

  /**
    * Check if the given sheet has any style rules without declarations, i.e. of the form "selector {}"
    */
  def removeEmptyRules(css : Css) : (Boolean, Css)


  /**
    * Check if the given sheet has any style rules with a  declaration for all four properties from the set
    * margin-left, margin-right, margin-top, and margin-bottom, and if so, replaces each property by
    * the single shorthand property margin. The new margin property takes the place of the first declaration in order of appearance.
    * The values from the individual prorperties are aggregated in the order top-right-bottom-left, with spaces in between.
    */
  def aggregateMargins(css: Css): (Boolean, Css)

  /**
    * Check if the given sheet contains strictly more than n 'float' properties and, if so, returns true, otherwise false.
    */
  def limitFloats(css: Css, n: Integer): Boolean

  /**
    * Check if this sheet has rules with overlapping selectors that try to assign a different value to a certain property. The selectors have to be exactly the same
    *
    * @param css The sheet
    * @return True iff there are clashing rules
    */
  def hasConflicts(css: Css): Boolean

  /**
    * Get violating rules , different to make the previous function more efficient (can stop after one found)
    *
    * @param css The sheet
    * @return True iff there are clashing rules
    */
  def getConflicts(css: Css): Seq[String]
}
