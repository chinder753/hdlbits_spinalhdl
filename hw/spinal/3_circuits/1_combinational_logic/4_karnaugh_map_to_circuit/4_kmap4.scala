package `3`.`1`.`4`.`4`


import spinal.core._
import config.Config

case class top_module() extends Component{
    val a, b, c, d = in Bool()
    val out_ = out Bool()

    out_ := a^b^c^d
}

object Kmap4 extends App{
    Config.spinal.generateVerilog(top_module())
}
