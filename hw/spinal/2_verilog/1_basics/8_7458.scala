package `2`.`1`.`8`


import spinal.core._
import config.Config

case class top_module() extends Component{
    val p1a, p2a = in Bool()
    val p1b, p2b = in Bool()
    val p1c, p2c = in Bool()
    val p1d, p2d = in Bool()
    val p1f, p1e = in Bool()
    val p1y, p2y = out Bool()

    val p2a2b = p2a & p2b
    val p2c2d = p2c & p2d
    val p1a1b1c = p1a & p1b & p1c
    val p1d1e1f = p1d & p1e & p1f

    p2y := p2a2b | p2c2d
    p1y := p1a1b1c | p1d1e1f
}

object _7458 extends App {
  Config.spinal.generateVerilog(top_module())
}
