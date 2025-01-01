package `3`.`2`.`1`.`18`

import spinal.core._
import config.Config

case class top_module() extends Component {
  val clk, d = in Bool()
  val q = out Bool()

  val coreClockDomian_r = ClockDomain(clk)
  val coreArea_r = new ClockingArea(coreClockDomian_r){
    val reg = Reg(Bool())
  }

  val coreClockDomian_f = ClockDomain(clk, config = ClockDomainConfig(FALLING))
  val coreArea_f = new ClockingArea(coreClockDomian_f){
    val reg = Reg(Bool())
  }

  coreArea_r.reg := d ^ coreArea_f.reg
  coreArea_f.reg := d ^ coreArea_r.reg

  q := coreArea_r.reg ^ coreArea_f.reg
}

object Dualedge extends App {
  Config.spinal.generateVerilog(top_module())
}
