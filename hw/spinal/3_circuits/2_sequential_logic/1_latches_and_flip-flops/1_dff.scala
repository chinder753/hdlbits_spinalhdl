package `3`.`2`.`1`.`1`

import spinal.core._
import config.Config

case class top_module() extends Component {
    val d, clk = in Bool ()
    val q = out Bool ()

    val coreClockDomain = ClockDomain(clk)
    val coreArea = new ClockingArea(coreClockDomain) {
        val regs = Reg(Bool())
    }

    coreArea.regs := d
    q := coreArea.regs    

}

object Dff extends App {
  Config.spinal.generateVerilog(top_module())
}
