package `2`.`1`.`2`


import spinal.core._
import config.Config

case class top_module() extends Component{
    val a, b, c = in Bool()
    val w, x, y, z = out Bool()

    w := a
    (x, y) := (b, b)
    z := c
}

object Wire4 extends App {
  Config.spinal.generateVerilog(top_module())
}
