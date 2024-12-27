package `2`.`2`.`9`


import spinal.core._
import config.Config

case class top_module() extends Component{
    val a, b, c, d, e = in Bool
    val out_ = out Bits(25 bits)

    val abcde = a##b##c##d##e

    for((x, i) <- Array(e, d, c, b, a).zipWithIndex){
      out_(i*5, 5 bits) := ~((x#*5) ^ abcde)
    }
}

object Vector5 extends App {
  Config.spinal.generateVerilog(top_module())
}
