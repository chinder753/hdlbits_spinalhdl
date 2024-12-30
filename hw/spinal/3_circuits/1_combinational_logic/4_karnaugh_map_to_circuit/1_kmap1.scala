package `3`.`1`.`4`.`1`


import spinal.core._
import config.Config

case class top_module() extends Component{
    val a, b, c = in Bool()
    val out_ = out Bool()

    out_ := a | b | c
}

object Kmap1 extends App{
    Config.spinal.generateVerilog(top_module())
}
