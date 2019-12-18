package sless.ast

case class MultiDeclaration(declarations: Seq[DeclarationImp]) extends DeclarationImp {
  override def compileDebug(): String =
    "<Multidec: " + declarations.foldRight("")((a, b) => a.compileDebug() + b) + ">"

}
