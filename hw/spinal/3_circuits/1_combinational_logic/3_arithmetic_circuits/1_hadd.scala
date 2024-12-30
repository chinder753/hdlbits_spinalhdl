package `3`.`1`.`3`.`1`


import spinal.core._
import config.Config

case class top_module() extends Component{
    val a, b = in Bool()
    val cout, sum = out Bool()

    cout := a & b
    sum := a ^ b
}

object Hadd extends App{
    Config.spinal.generateVerilog(top_module())
}
