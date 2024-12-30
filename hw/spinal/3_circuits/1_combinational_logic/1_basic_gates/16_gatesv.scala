package `3`.`1`.`1`.`16`


import spinal.core._
import config.Config


case class top_module() extends Component{
    val in_ = in Bits(4 bits)
    val out_both, out_any = out Bits(3 bits)
    val out_different = out Bits(4 bits)

    val in_left = in_(0, 3 bits)
    out_both := in_(1, 3 bits) & in_left
    out_any := in_(1, 3 bits) | in_left
    
    out_different(0, 3 bits) := in_(1, 3 bits) ^ in_left
    out_different(3) := in_(3) ^ in_(0)
}

object Gatesv extends App{
    Config.spinal.generateVerilog(top_module())
}
