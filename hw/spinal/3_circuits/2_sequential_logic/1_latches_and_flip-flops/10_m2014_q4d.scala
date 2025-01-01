package `3`.`2`.`1`.`10`

import spinal.core._
import config.Config

case class top_module() extends Component {
  val clk, in_ = in Bool ()
  val out_ = out Bool()

  val coreClockDomian = ClockDomain(clk)
  val coreArea = new ClockingArea(coreClockDomian){
    val latch = Reg(Bool())
  }

  coreArea.latch := in_ ^ coreArea.latch
  out_ := coreArea.latch
}

object M2014Q4b extends App {
  Config.spinal.generateVerilog(top_module())
}
