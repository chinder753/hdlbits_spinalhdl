package `3`.`1`.`1`.`8`


import spinal.core._
import config.Config

case class top_module() extends Component{
    val x1 = in Bool()
    val x2 = in Bool()
    val x3 = in Bool()
    val f = out Bool()

    f := (x3##x2##x1).mux(
        B"000" -> False,
        B"001" -> False,
        B"010" -> True,
        B"011" -> True,
        B"100" -> False,
        B"101" -> True,
        B"110" -> False,
        B"111" -> True,
    )
}

object Truthtable1 extends App{
    Config.spinal.generateVerilog(top_module())
}
