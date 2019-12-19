package sless.ast

abstract class DeclarationImp extends CompilableImp {
  val margins: Seq[String] = Seq("margin-top", "margin-right", "margin-bottom", "margin-left")

  def condense(): DeclarationImp

  def allMargins(): Boolean

  def notEmpty(): Boolean

  def hasProp(prop: String): Boolean

  def getFirst: Option[DeclarationImp]

  def collect(prop: String): Option[String]

  def replace(orig: DeclarationImp, repl: DeclarationImp): DeclarationImp

  def removeMargins: Option[DeclarationImp]

  def aggrProp(prop: String): Int
}
