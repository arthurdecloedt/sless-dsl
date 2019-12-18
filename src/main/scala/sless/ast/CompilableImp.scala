package sless.ast

trait CompilableImp {

  def compileDebug(): String = ""

  def compile(): String = ""

  def prettyPrint(indent: Int): String = compile()


}
