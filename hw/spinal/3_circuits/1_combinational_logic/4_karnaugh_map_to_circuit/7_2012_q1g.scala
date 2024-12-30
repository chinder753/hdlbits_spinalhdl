package `3`.`1`.`4`.`7`


import spinal.core._
import config.Config

case class top_module() extends Component{
    val x = in Bits(4 bits)
    val f = out Bool()

    val a = x(0)
    val b = x(1)
    val c = x(2)
    val d = x(3)

    f := (!b)&(!d) | (!a)&(c) | (b)&(c)&(d)
}

object _2012Q1g extends App{
    Config.spinal.generateVerilog(top_module())
}
