package `2`.`3`.`4`


import spinal.core._
import config.Config


class my_dff() extends BlackBox{
    val clk, d = in Bool()
    val q = out Bool()
}

case class top_module() extends Component{
    val clk, d = in Bool()
    val q = out Bool()

    val md1, md2, md3 = new my_dff()
    md1.clk <> clk
    md2.clk <> clk
    md3.clk <> clk

    d <> md1.d
    md1.q <> md2.d
    md2.q <> md3.d
    md3.q <> q
}

object ModuleShift extends App {
  Config.spinal.generateVerilog(top_module())
}
