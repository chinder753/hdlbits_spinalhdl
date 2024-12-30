package `3`.`1`.`4`.`8`


import spinal.core._
import config.Config

case class top_module() extends Component{
    val c, d = in Bool()
    val mux_in = out Bits(4 bits)

    mux_in := (c##d).mux(
        B"00" -> B"0100",
        B"01" -> B"0001",
        B"11" -> B"1001",
        B"10" -> B"0101",
    )
}

object Ece241_2014Q3 extends App{
    Config.spinal.generateVerilog(top_module())
}
