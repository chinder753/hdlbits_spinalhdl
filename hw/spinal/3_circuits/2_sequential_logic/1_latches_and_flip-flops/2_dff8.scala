package `3`.`2`.`1`.`2`

import spinal.core._
import config.Config

case class top_module() extends Component {
    val d = in Bits(8 bits)
    val clk = in Bool ()
    val q = out Bits(8 bits)

    val coreClockDomain = ClockDomain(clk)
    val coreArea = new ClockingArea(coreClockDomain) {
        val regs = Reg(Bits(8 bits))
    }

    coreArea.regs := d
    q := coreArea.regs    

}

object Dff8 extends App {
  Config.spinal.generateVerilog(top_module())
}
