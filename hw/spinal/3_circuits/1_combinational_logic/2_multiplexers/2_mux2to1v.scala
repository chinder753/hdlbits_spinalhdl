package `3`.`1`.`2`.`2`


import spinal.core._
import config.Config

case class top_module() extends Component{
    val a, b = in Bits(100 bits)
    val sel = in Bool()
    val out_ = out Bits(100 bits)

    out_ := Mux(sel, b, a)
}

object Mux2to1v extends App{
    Config.spinal.generateVerilog(top_module())
}
