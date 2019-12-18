package sless.ast

import sless.ast.selectors._
import sless.dsl._

class ParserBase extends BaseDSL with PropertyDSL with SelectorDSL with Compilable with ValueDSL {
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

  def compile(sheet: CssImp): String = sheet.compileDebug()

  def pretty(sheet: CssImp, spaces: Int): String = ???

  def value(string: String): ValueImp = ValueImp(string)
}
