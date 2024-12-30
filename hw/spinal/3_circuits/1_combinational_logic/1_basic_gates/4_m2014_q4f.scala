package `3`.`1`.`1`.`4`


import spinal.core._
import config.Config

case class top_module() extends Component{
    val in1 = in Bool()
    val in2 = in Bool()
    val out_ = out Bool()

    out_ := in1&(!in2)
}

object M2014Q4f extends App{
    Config.spinal.generateVerilog(top_module())
}
