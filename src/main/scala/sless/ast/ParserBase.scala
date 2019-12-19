package sless.ast

import sless.ast.selectors._
import sless.dsl._

class ParserBase extends BaseDSL with PropertyDSL with SelectorDSL with Compilable with ValueDSL with LintDSL {
  type Rule = RuleImp
  type Css = CssImp
  type Selector = SelectorImp
  type Declaration = DeclarationImp
  type Property = PropertyImp
  type Value = ValueImp

  protected def fromRules(rules: Seq[Rule]): CssImp = CssImp(rules)

  def prop(string: String): PropertyImp = PropertyImp(string)

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

  def tipe(string: String): SelectorImp = TypeSelector(string)

  val All: SelectorImp = AllSelector()

  protected def bindTo(s: SelectorImp, declarations: Seq[DeclarationImp]): RuleImp = RuleImp(s, MultiDeclaration(declarations))

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
}
