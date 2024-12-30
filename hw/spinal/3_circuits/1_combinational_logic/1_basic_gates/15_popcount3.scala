package `3`.`1`.`1`.`15`


import spinal.core._
import config.Config


case class top_module() extends Component{
    val in_ = in Bits(3 bits)
    val out_ = out Bits(2 bits)

    out_ := ((in_(0).asUInt +^ in_(1).asUInt) + in_(2).asUInt).asBits
}

object Popcount3 extends App{
    Config.spinal.generateVerilog(top_module())
}
