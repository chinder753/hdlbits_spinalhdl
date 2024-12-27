package `2`.`1`.`5`


import spinal.core._
import config.Config

case class top_module() extends Component{
    val a, b = in Bool()
    val out_ = out Bool()

    out_ := !(a | b)
}

object Norgate extends App {
  Config.spinal.generateVerilog(top_module())
}
