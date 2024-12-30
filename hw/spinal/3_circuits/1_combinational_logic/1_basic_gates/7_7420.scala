package `3`.`1`.`1`.`7`


import spinal.core._
import config.Config

case class top_module() extends Component{
    val p1a = in Bool()
    val p1b = in Bool()
    val p1c = in Bool()
    val p1d = in Bool()
    val p1y = out Bool()

    p1y := !(p1a & p1b & p1c & p1d)

    val p2a = in Bool()
    val p2b = in Bool()
    val p2c = in Bool()
    val p2d = in Bool()
    val p2y = out Bool()

    p2y := !(p2a & p2b & p2c & p2d)
        
}

object _7420 extends App{
    Config.spinal.generateVerilog(top_module())
}
