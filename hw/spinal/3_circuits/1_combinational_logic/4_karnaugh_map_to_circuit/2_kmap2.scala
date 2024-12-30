package `3`.`1`.`4`.`2`


import spinal.core._
import config.Config

case class top_module() extends Component{
    val a, b, c, d = in Bool()
    val out_ = out Bool()

    out_ := ((!b)&(!c)) | ((!a)&(!d)) | ((!a)&(b)&(c)) | ((a)&(c)&(d))
}

object Kmap2 extends App{
    Config.spinal.generateVerilog(top_module())
}
