package `3`.`1`.`1`.`11`


import spinal.core._
import config.Config

case class top_module() extends Component{
    val x, y = in Bool()
    val z = out Bool()

    z := !(x^y)
}

object Mt2015Q4b extends App{
    Config.spinal.generateVerilog(top_module())
}
