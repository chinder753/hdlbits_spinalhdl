package `3`.`1`.`1`.`9`


import spinal.core._
import config.Config

case class top_module() extends Component{
    val A, B = in Bits(2 bits)
    val z = out Bool()

    z := A === B
}

object Mt2015Eq2 extends App{
    Config.spinal.generateVerilog(top_module())
}
