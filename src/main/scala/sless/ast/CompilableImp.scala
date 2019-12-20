package sless.ast

trait CompilableImp {

  def compileDebug(): String = ""

  def prettyPrint(indent: Int): String = compile()

  def compile(): String = ""


}
