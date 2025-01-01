package `3`.`2`.`1`.`8`

import spinal.core._
import config.Config

case class top_module() extends Component {
  val clk, d, ar = in Bool ()
  val q = out Bool()

  val coreClockDomian = ClockDomain(clk, ar)
  val coreArea = new ClockingArea(coreClockDomian){
    val latch = Reg(Bool()) init False
  }

  coreArea.latch := d
  q := coreArea.latch
}

object M2014Q4b extends App {
  Config.spinal.generateVerilog(top_module())
}
