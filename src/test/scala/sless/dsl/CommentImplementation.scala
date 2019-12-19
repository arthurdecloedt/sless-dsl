package sless.dsl

import sless.ast.ParserBase

object CommentImplementation {
  type DSL = PropertyDSL with SelectorDSL with ValueDSL with CommentDSL with Compilable
  val dsl: DSL = new ParserBase
}
