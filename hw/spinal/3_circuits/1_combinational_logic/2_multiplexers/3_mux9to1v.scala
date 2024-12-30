package `3`.`1`.`2`.`3`


import spinal.core._
import config.Config

case class top_module() extends Component{
    val a, b, c, d, e, f, g, h, i = in Bits(16 bits)
    val sel = in Bits(4 bits)
    val out_ = out Bits(16 bits)

    out_ := sel.mux(
        0 -> a,
        1 -> b,
        2 -> c,
        3 -> d,
        4 -> e,
        5 -> f,
        6 -> g,
        7 -> h,
        8 -> i,
        default -> B"xFFFF"
    )
}

object Mux9to1v extends App{
    Config.spinal.generateVerilog(top_module())
}
