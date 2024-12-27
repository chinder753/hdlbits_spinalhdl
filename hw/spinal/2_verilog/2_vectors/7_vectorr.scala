package `2`.`2`.`7`


import spinal.core._
import config.Config

case class top_module() extends Component{
    val in_ = in Bits(8 bits)
    val out_ = out Bits(8 bits)

    out_ := in_.reversed
}

object Vectorr extends App {
  Config.spinal.generateVerilog(top_module())
}
