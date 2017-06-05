package co.ejemplos.typeclass

import Printable._
import PrintableInstances._
import PrintableSyntax._

/**
 * Utilizacion del type class.
 *
 * Created by abelmeos on 2017/06/05.
 */
object Main extends App{

  final case class Cat(name:String, age:Int, color:String)

  implicit val catPrintable = new Printable[Cat] {

    def format(cat:Cat) = {
      val name = Printable.format(cat.name)
      val age = Printable.format(cat.age)
      val color = Printable.format(cat.color)
      s"$name is a $age year-old $color cat."
    }

  }

  val cat = Cat("leo", 10, "negro" )

  Printable.print(cat)

  Cat("oscar",12,"blanco").print

}
