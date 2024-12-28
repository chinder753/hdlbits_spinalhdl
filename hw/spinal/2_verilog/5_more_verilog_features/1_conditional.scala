package `2`.`5`.`1`


import spinal.core._
import config.Config

case class top_module() extends Component{
    val a, b, c, d = in UInt(8 bits)
    val min = out UInt(8 bits)

    var ab_min = a.min(b)
    var cd_min = c.min(d)
    min := ab_min.min(cd_min)
}

object Conditonal extends App{
    Config.spinal.generateVerilog(top_module())
}

