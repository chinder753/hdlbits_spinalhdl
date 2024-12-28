package `2`.`5`.`4`


import spinal.core._
import config.Config

case class top_module() extends Component{
    val in_ = in Bits(100 bits)
    val out_ = out Bits(100 bits)

    out_ := in_.reversed
}

object Vector100r extends App{
    Config.spinal.generateVerilog(top_module())
}

