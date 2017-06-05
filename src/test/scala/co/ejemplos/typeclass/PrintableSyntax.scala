package co.ejemplos.typeclass

/**
 * 
 * se crea una nueva implementacion para agregar metodos al
 * type class principal.
 *
 * ya no es necesario imprimir desde la instancia Printable
 * debido a que con esta extension implicitamente se detecta
 * un printable y proporciona el metodo print.
 *
 * Created by abelmeos on 2017/06/05.
 */
object PrintableSyntax {

  implicit class Print0ps[A](value:A){

    def format(implicit p:Printable[A]):String = p.format(value)

    def print(implicit  p:Printable[A]):Unit = println(p.format(value))

  }

}
