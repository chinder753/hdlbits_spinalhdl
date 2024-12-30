package `3`.`1`.`1`.`1`


import spinal.core._
import config.Config

case class top_module() extends Component{
    val in_ = in Bool()
    val out_ = out Bool()

    out_ := in_
}

object M2014Q4h extends App{
    Config.spinal.generateVerilog(top_module())
}
