package `3`.`1`.`1`.`10`


import spinal.core._
import config.Config

case class top_module() extends Component{
    val x, y = in Bool()
    val z = out Bool()

    z := (x^y)&x
}

object Mt2015Q4a extends App{
    Config.spinal.generateVerilog(top_module())
}
