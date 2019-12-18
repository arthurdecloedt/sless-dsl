package sless.dsl

import sless.ast.ParserBase

object CssImplementation {
  type DSL = PropertyDSL with SelectorDSL with ValueDSL with Compilable
  val dsl: DSL = {
    new ParserBase()
  }
}
