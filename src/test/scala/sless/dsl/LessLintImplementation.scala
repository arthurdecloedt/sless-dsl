package sless.dsl

import sless.ast.ParserBase

object LessLintImplementation {
  type DSL = PropertyDSL with SelectorDSL with ValueDSL with LintDSL with Compilable
  val dsl: DSL = {
    new ParserBase
  }
}
