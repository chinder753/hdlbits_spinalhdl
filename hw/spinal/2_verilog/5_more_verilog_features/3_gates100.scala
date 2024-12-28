package `2`.`5`.`3`


import spinal.core._
import config.Config

case class top_module() extends Component{
    val in_ = in Bits(100 bits)
    val out_and, out_or, out_xor = out Bool()

    out_and := in_.andR
    out_or := in_.orR
    out_xor := in_.xorR
}

object Gates100 extends App{
    Config.spinal.generateVerilog(top_module())
}

