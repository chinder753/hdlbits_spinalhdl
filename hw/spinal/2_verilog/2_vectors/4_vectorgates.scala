package `2`.`2`.`4`


import spinal.core._
import config.Config

case class top_module() extends Component{
    val a, b = in Bits(3 bits)
    val out_or_bitwise = out Bits(3 bits)
    val out_or_logical = out Bool()
    val out_not = out Bits(6 bits)

    val or_bitwise = a | b
    val or_logical = or_bitwise.orR

    out_or_bitwise := or_bitwise
    out_or_logical := or_logical
    out_not := (~a) ## (~b)
}

object Vectorgates extends App {
  Config.spinal.generateVerilog(top_module())
}
