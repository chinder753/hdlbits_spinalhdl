package `3`.`2`.`1`.`11`

import spinal.core._
import config.Config

case class top_module() extends Component {
  val clk, L, r_in, q_in = in Bool ()
  val Q = out Bool()

  val coreClockDomian = ClockDomain(clk)
  val coreArea = new ClockingArea(coreClockDomian){
    val latch = Reg(Bool())
  }

  coreArea.latch := Mux(L, r_in, q_in)
  Q := coreArea.latch
}

object M2015Muxdff extends App {
  Config.spinal.generateVerilog(top_module())
}
