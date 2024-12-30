package `3`.`1`.`4`.`6`


import spinal.core._
import config.Config

case class top_module() extends Component{
    val x = in Bits(4 bits)
    val f = out Bool()

    val a = x(0)
    val b = x(1)
    val c = x(2)
    val d = x(3)

    f := (a)&(b)&(!c)&(d) | (!a)&(c)
}

object M2014Q3 extends App{
    Config.spinal.generateVerilog(top_module())
}
