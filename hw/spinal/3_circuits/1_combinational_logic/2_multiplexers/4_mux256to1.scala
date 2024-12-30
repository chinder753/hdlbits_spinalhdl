package `3`.`1`.`2`.`4`


import spinal.core._
import config.Config

case class top_module() extends Component{
    val in_ = in Bits(1024 bits)
    val sel = in UInt(8 bits)
    val out_ = out Bits(4 bits)

    out_ := in_(sel*4, 4 bits)
}

object Mux9to1v extends App{
    Config.spinal.generateVerilog(top_module())
}
