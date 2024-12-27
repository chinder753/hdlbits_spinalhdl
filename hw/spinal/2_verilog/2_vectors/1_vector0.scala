package `2`.`2`.`1`


import spinal.core._
import config.Config

case class top_module() extends Component{
    val vec = in Bits(3 bits)
    val outv = out Bits(3 bits)
    val o2, o1, o0 = out Bool()

    outv := vec
    (o2, o1, o0) := vec
}

object Vector0 extends App {
  Config.spinal.generateVerilog(top_module())
}
