package `3`.`2`.`1`.`12`

import spinal.core._
import config.Config

case class top_module() extends Component {
  val clk, w, R, E, L = in Bool ()
  val Q = out Bool()

  val coreClockDomian = ClockDomain(clk)
  val coreArea = new ClockingArea(coreClockDomian){
    val latch = Reg(Bool())
  }

  coreArea.latch := (E##L).mux(
    B"10" -> w,
    M"-1" -> R,
    default -> coreArea.latch,
  )
  Q := coreArea.latch
}

object M2014Q4a extends App {
  Config.spinal.generateVerilog(top_module())
}
