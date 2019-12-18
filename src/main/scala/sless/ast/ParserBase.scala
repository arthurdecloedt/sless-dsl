package sless.ast

import com.sun.tools.internal.xjc.reader.xmlschema.ClassSelector
import sless.dsl.{BaseDSL, PropertyDSL, SelectorDSL}
import sless.ast.selectors.{AdjacentSelector, AttributeSelector, ClassSelector, IdSelector, PseudoClassSelector, SelectorRoot, SelectorUnary}
class ParserBase extends BaseDSL with PropertyDSL with SelectorDSL{
  type Rule = RuleImp
  type Css = CssImp
  type Selector = SelectorImp
  type Declaration = DeclarationImp
  type Property = PropertyImp
  type Value = ValueImp

  protected def fromRules(rules: Seq[Rule ]): CssImp = CssImp(rules)

  def prop(string: String): PropertyImp = PropertyImp(string)

  protected def assign(p: PropertyImp, value: ValueImp): DeclarationImp = DeclarationImp(p,value)

  protected def className(s: SelectorImp, string: String): SelectorImp = ClassSelector(s,string)

  protected def id(s: SelectorImp, string: String): SelectorImp = IdSelector(s,string)

  protected def attribute(s: SelectorImp, attr: String, value: ValueImp): SelectorImp = AttributeSelector(s,attr,value)

  protected def pseudoClass(s: SelectorImp, string: String): SelectorImp = PseudoClassSelector(s,string)

  protected def pseudoElement(s: SelectorImp, string: String): SelectorImp = ???

  /** -> s + selector { ... } */
  protected def adjacent(s: SelectorImp, selector: SelectorImp): SelectorImp = AdjacentSelector(s,selector)

  /** -> s ~ selector { ... } */
  protected def general(s: SelectorImp, selector: SelectorImp): SelectorImp =

  /** -> s > selector { ... } */
  protected def child(s: SelectorImp, selector: SelectorImp): SelectorImp = ???

  /** -> s selector { ... } */
  protected def descendant(s: SelectorImp, selector: SelectorImp): SelectorImp = ???

  protected def group(selectors: Seq[SelectorImp]): SelectorImp = ???

  def tipe(string: String): SelectorImp = ???

  val All: SelectorImp = ???

  protected def bindTo(s: SelectorImp, declarations: Seq[DeclarationImp]): RuleImp = ???
}
