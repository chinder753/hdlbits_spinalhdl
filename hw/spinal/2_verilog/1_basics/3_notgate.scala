package `2`.`1`.`3`


import spinal.core._
import config.Config

case class top_module() extends Component{
    val in_ = in Bool()
    val out_ = out Bool()

    out_ := !in_
}

object Notgate extends App {
  Config.spinal.generateVerilog(top_module())
}
