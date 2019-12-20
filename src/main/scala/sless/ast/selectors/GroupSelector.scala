package sless.ast.selectors

import sless.ast.SelectorImp

case class GroupSelector(selectors: Seq[SelectorImp]) extends SelectorImp {
  override lazy val getHashes: Seq[Int] = selectors.flatMap(_.getHashes)
  override val debugName: String = "Group"

  //  override def compile(): String = if (selectors.size ==  1)( selectors.foldRight("")((a, b) => a.compile() + "," + b)) else selectors.head.compile()
  override def compile(): String = selectors.foldRight("")((a, b) => a.compile() + (if (b == "") "" else ",") + b)

  override def prettyPrint(indent: Int): String = selectors.foldRight("")((a, b) => a.prettyPrint(indent) + (if (b == "") "" else ", ") + b)

}