package sless.ast

case class MultiDeclaration(declarations: Seq[DeclarationImp]) extends DeclarationImp {
  override def compileDebug(): String =
    "<Multidec: " + declarations.foldRight("")((a, b) => a.compileDebug() + b) + ">"

  override def compile(): String = declarations.foldRight("")((a, b) => a.compile() + b)

  override def prettyPrint(indent: Int): String = declarations.foldLeft("")((a, b) => a + b.prettyPrint(indent))
}

