package `3`.`1`.`1`.`2`


import spinal.core._
import config.Config

case class top_module() extends Component{
    val out_ = out Bool()

    out_ := False
}

object M2014Q4i extends App{
    Config.spinal.generateVerilog(top_module())
}
