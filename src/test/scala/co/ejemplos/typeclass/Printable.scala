package co.ejemplos.typeclass

/**
 *
 * Ejemplo de type class  como introduccion a Cats
 *
 * Created by abelmeos on 2017/06/05.
 */
trait Printable[A] {
  def format(value:A):String
}


object PrintableInstances{

  implicit val formatString = new Printable[String] {

    def format(input:String) = input

  }

  implicit val formatInt = new Printable[Int] {

    def format(input:Int) = input.toString

  }

}

object Printable {

  def format[A](input:A)(implicit p: Printable[A]):String = p.format(input)

  def print[A](input:A)(implicit p: Printable[A]):Unit = println(format(input))

}