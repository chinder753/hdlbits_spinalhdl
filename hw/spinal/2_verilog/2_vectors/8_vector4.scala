package `2`.`2`.`8`


import spinal.core._
import config.Config

case class top_module() extends Component{
    val in_ = in Bits(8 bits)
    val out_ = out Bits(32 bits)

    out_ := (in_(7) #* 24) ## in_
}

object Vector4 extends App {
  Config.spinal.generateVerilog(top_module())
}
