package co.ejemplos.typeclass.cats

import java.util.Date

import cats.Eq
import cats.instances.all._
import cats.syntax.eq._


/**
  * Ejemplo del TypeClass Eq de Cats
  * Created by ALEJANDRO on 05/08/2017.
  */
object EqMain {

  def main(args: Array[String]): Unit = {

    val eqInt = Eq[Int]

    println(eqInt.eqv(123,123))

    // ejemplo de la interface syntax de Eq
    123 === 123

    // Ejemplo con options
    (Some(1):Option[Int]) === (None:Option[Int])

    Option(1) === Option.empty[Int]

    // y utilizdo syntax...

    //1.some === None

    // creando mi propia instancia para Eq

    implicit val dataEqual = Eq.instance[Date]{
      (date1,date2) => date1.getTime === date2.getTime
    }
    val x = new Date()
    val y = new Date()

    println(x === x)
    println(x === y)
  }

}
