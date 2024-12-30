package `3`.`1`.`4`.`3`


import spinal.core._
import config.Config

case class top_module() extends Component{
    val a, b, c, d = in Bool()
    val out_ = out Bool()

    out_ := ((a)&(!c)&(!d)) | ((!b)&(c)) | ((a)&(c))
}

object Kmap3 extends App{
    Config.spinal.generateVerilog(top_module())
}
