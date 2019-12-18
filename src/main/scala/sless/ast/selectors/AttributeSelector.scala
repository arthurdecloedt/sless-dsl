package sless.ast.selectors

import sless.ast.{PropertyImp, SelectorImp, ValueImp}

case class AttributeSelector(selector: SelectorImp, string :String, value:ValueImp) extends SelectorImp {

}
