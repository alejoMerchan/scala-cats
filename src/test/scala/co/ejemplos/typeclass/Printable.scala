package co.ejemplos.typeclass

/**
 *
 * Ejemplo de type class  como introduccion a Cats.
  *
  * Patron de programacion que permite agregar nuevas funcionalidades a librerias, sin utilizar su inherencia o
  * alterar su codigo fuente.
 *
 * Created by abelmeos on 2017/06/05.
 */

/**
  * Definicion del typeclass.
  *
  * Representa alguna funcionalidad a ser implementada.
  *
  * @tparam type A and return String
  */
trait Printable[A] {
  def format(value:A):String
}


/**
  * Instancias del printable para String y para Int.
  *
  * Provee la implementacion para cualquier type
  *
  */
object PrintableInstances{

  implicit val formatString = new Printable[String] {

    def format(input:String) = input

  }

  implicit val formatInt = new Printable[Int] {

    def format(input:Int) = input.toString

  }

}

/**
  * Definicion del objeto con dos interfaces genericas.
  *
  * Expone las funcionalidades al usuario.
  *
  */
object Printable {

  def format[A](input:A)(implicit p: Printable[A]):String = p.format(input)

  def print[A](input:A)(implicit p: Printable[A]):Unit = println(format(input))

}