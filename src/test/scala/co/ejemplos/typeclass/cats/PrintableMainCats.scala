package co.ejemplos.typeclass.cats

import cats.Show
import cats.instances.all._
import cats.syntax.show._

/**
  * Ejemplo en cats de la libreria Printable.
  *
  * Created by ALEJANDRO on 05/08/2017.
  */
object PrintableMainCats {

  final case class Cat(name:String, age:Int, color:String)

  def main(args: Array[String]): Unit = {

    // se crea la instancia para el tipo [Cat]
    implicit val catShow = Show.show[Cat] {
      cat =>
        val name = cat.name.show
        val age = cat.age.show
        val color = cat.color.show

        s"$name is a $age year-old $color cat"
    }


    // Se utliza la interface show.
    println(Cat("Alejandro", 29, "negro").show)

  }

}
