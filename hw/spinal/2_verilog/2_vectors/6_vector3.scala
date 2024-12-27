package `2`.`2`.`6`


import spinal.core._
import config.Config

case class top_module() extends Component{
    val a, b, c, d, e, f = in Bits(5 bits)
    val w, x, y, z = out Bits(8 bits)

    (w, x, y, z) := (a, b, c, d, e, f, B"11")
}

object Vector3 extends App {
  Config.spinal.generateVerilog(top_module())
}
