package `2`.`3`.`5`


import spinal.core._
import config.Config


class my_dff8() extends BlackBox{
    val clk = in Bool()
    val d = in Bits(8 bits)
    val q = out Bits(8 bits)
}

case class top_module() extends Component{
    val clk = in Bool()
    val d = in Bits(8 bits)
    val sel = in Bits(2 bits)
    val q = out Bits(8 bits)

    val md1, md2, md3 = new my_dff8()
    md1.clk <> clk
    md2.clk <> clk
    md3.clk <> clk

    d <> md1.d
    md1.q <> md2.d
    md2.q <> md3.d

    q := sel.mux(
      0 -> d,
      1 -> md1.q,
      2 -> md2.q,
      3 -> md3.q
    )
}

object ModuleShift8 extends App {
  Config.spinal.generateVerilog(top_module())
}
