package co.ejemplos.typeclass.cats

import java.util.Date

import cats.Show
import cats.instances.all._
import cats.syntax.show._
/**
  *
  * En Cats las TypeClass estan en el paquete cats [import cats].
  * Las instancias estan en cats.instances.
  * La interface syntax esta en cats.syntax.
  *
  * Created by ALEJANDRO on 04/08/2017.
  */
object MainCats {

  val showInt:Show[Int] = Show.apply[Int]
  val showString:Show[String] = Show.apply[String]


  def main(args: Array[String]): Unit = {

    val intAsString = showInt.show(123);
    val stringAsString = showString.show ("abc")

    // Ejemplo utilizando el Syntax de show.
    val showIntSyntax = 123.show
    val showStringSyntax = "abc".show

    // Definiendo instancias para nuestrs propios tipos.
    implicit val dateShow:Show[Date] = Show.show(date => s"${date.getTime}ms tiempo en string")

    println(new Date().show)


  }
}
