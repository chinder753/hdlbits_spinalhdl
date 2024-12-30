package `3`.`1`.`2`.`1`


import spinal.core._
import config.Config

case class top_module() extends Component{
    val a, b, sel = in Bool()
    val out_ = out Bool()

    out_ := Mux(sel, b, a)
}

object Mux2to1 extends App{
    Config.spinal.generateVerilog(top_module())
}
