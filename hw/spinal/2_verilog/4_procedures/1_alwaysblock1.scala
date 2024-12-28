package `2`.`4`.`1`


import spinal.core._
import config.Config

case class top_module() extends Component{
    val a, b = in Bool()
    val out_assign = out Bool()
    val out_alwaysblock = out Bool()

    val ab = a & b
    out_assign := ab
    out_alwaysblock := ab
}

object Alwaysblock1 extends App {
  Config.spinal.generateVerilog(top_module())
}
