package `2`.`2`.`2`


import spinal.core._
import config.Config

case class top_module() extends Component{
    val in_ = in Bits(16 bits)
    val out_hi, out_lo = out Bits(8 bits)

    (out_hi, out_lo) := in_
}

object Vector1 extends App {
  Config.spinal.generateVerilog(top_module())
}
