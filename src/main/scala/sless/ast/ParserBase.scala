package sless.ast

import sless.ast.selectors._
import sless.dsl._

class ParserBase extends BaseDSL with PropertyDSL with SelectorDSL with Compilable with ValueDSL with LintDSL with CommentDSL {
  type Rule = RuleImp
  type Css = CssImp
  type Selector = SelectorImp
  type Declaration = DeclarationImp
  type Property = PropertyImp
  type Value = ValueImp
  val All: SelectorImp = AllSelector()

  def prop(string: String): PropertyImp = PropertyImp(string)

  def tipe(string: String): SelectorImp = TypeSelector(string)

  def compile(sheet: CssImp): String = sheet.compile()

  def pretty(sheet: CssImp, spaces: Int): String = sheet.prettyPrint(indent = spaces)

  def value(string: String): ValueImp = ValueImp(string)

  /**
    * Check if the given sheet has any style rules without declarations, i.e. of the form "selector {}"
    */
  def removeEmptyRules(css: CssImp): (Boolean, CssImp) = css.removeEmptyRules()

  /**
    * Check if the given sheet has any style rules with a  declaration for all four properties from the set
    * margin-left, margin-right, margin-top, and margin-bottom, and if so, replaces each property by
    * the single shorthand property margin. The new margin property takes the place of the first declaration in order of appearance.
    * The values from the individual prorperties are aggregated in the order top-right-bottom-left, with spaces in between.
    */
  def aggregateMargins(css: CssImp): (Boolean, CssImp) = css.condenseMargins()

  /**
    * Check if the given sheet contains strictly more than n 'float' properties and, if so, returns true, otherwise false.
    */
  def limitFloats(css: CssImp, n: Integer): Boolean = css.aggrProp("float") > n

  /**
    * Check if this sheet has rules with overlapping selectors that try to assign a different value to a certain property. The selectors have to be exactly the same
    *
    * @param css The sheet
    * @return True iff there are clashing rules
    */
  def hasConflicts(css: CssImp): Boolean = css.hasConflicts

  /**
    * Get violating rules , different to make the previous function more efficient (can stop after one found)
    *
    * @param css The sheet
    * @return True iff there are clashing rules
    */
  def getConflicts(css: CssImp): Seq[String] = css.getConflicts

  protected def fromRules(rules: Seq[Rule]): CssImp = CssImp(rules)

  protected def assign(p: PropertyImp, value: ValueImp): DeclarationImp = MonoDeclaration(p, value)

  protected def className(s: SelectorImp, string: String): SelectorImp = ClassSelector(s, string)

  protected def id(s: SelectorImp, string: String): SelectorImp = IdSelector(s, string)

  protected def attribute(s: SelectorImp, attr: String, value: ValueImp): SelectorImp = AttributeSelector(s, attr, value)

  protected def pseudoClass(s: SelectorImp, string: String): SelectorImp = PseudoClassSelector(s, string)

  protected def pseudoElement(s: SelectorImp, string: String): SelectorImp = PseudoElementSelector(s, string)

  /** -> s + selector { ... } */
  protected def adjacent(s: SelectorImp, selector: SelectorImp): SelectorImp = AdjacentSelector(s, selector)

  /** -> s ~ selector { ... } */
  protected def general(s: SelectorImp, selector: SelectorImp): SelectorImp = GeneralSelector(s, selector)

  /** -> s > selector { ... } */
  protected def child(s: SelectorImp, selector: SelectorImp): SelectorImp = ChildSelector(s, selector)

  /** -> s selector { ... } */
  protected def descendant(s: SelectorImp, selector: SelectorImp): SelectorImp = DescendantSelector(s, selector)

  protected def group(selectors: Seq[SelectorImp]): SelectorImp = GroupSelector(selectors)

  protected def bindTo(s: SelectorImp, declarations: Seq[DeclarationImp]): RuleImp = RuleImp(s, MultiDeclaration(declarations))

  protected def commentRule(rule: RuleImp, str: String): RuleImp = rule.addComment(str)

  protected def commentDeclaration(declaration: DeclarationImp, str: String): DeclarationImp = declaration.addComment(str)
}
