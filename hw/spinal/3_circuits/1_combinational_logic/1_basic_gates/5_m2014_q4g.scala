package `3`.`1`.`1`.`5`


import spinal.core._
import config.Config

case class top_module() extends Component{
    val in1, in2, in3 = in Bool()
    val out_ = out Bool()

    val in12 = !(in1 ^ in2)
    out_ := in12 ^ in3
}

object M2014Q4g extends App{
    Config.spinal.generateVerilog(top_module())
}
