package `3`.`1`.`1`.`17`


import spinal.core._
import config.Config


case class top_module() extends Component{
    val in_ = in Bits(100 bits)
    val out_both, out_any = out Bits(99 bits)
    val out_different = out Bits(100 bits)

    val in_left = in_(0, 99 bits)
    out_both := in_(1, 99 bits) & in_left
    out_any := in_(1, 99 bits) | in_left
    
    out_different(0, 99 bits) := in_(1, 99 bits) ^ in_left
    out_different(99) := in_(99) ^ in_(0)
}

object Gatesv100 extends App{
    Config.spinal.generateVerilog(top_module())
}
