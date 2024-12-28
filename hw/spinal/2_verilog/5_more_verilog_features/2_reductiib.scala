package `2`.`5`.`2`


import spinal.core._
import config.Config

case class top_module() extends Component{
    val in_ = in Bits(8 bits)
    val parity = out Bool()

    parity := in_.xorR
}

object Reductiib extends App{
    Config.spinal.generateVerilog(top_module())
}

