package sless.ast.selectors

import sless.ast.SelectorImp

case class GroupSelector(selectors: Seq[SelectorImp]) extends SelectorImp {
  override val debugName: String = "Group"
}