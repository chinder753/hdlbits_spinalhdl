package `3`.`2`.`1`.`17`

import spinal.core._
import config.Config

case class top_module() extends Component {
  val clk, reset = in Bool()
  val in_ = in Bits(32 bits)
  val out_ = out Bits(32 bits)

  val coreClockDomian = ClockDomain(clk, reset, config = ClockDomainConfig(resetKind = SYNC))
  val coreArea = new ClockingArea(coreClockDomian){
    val reg = Reg(Bits(32 bits))
    val result = Reg(Bits(32 bits)) init B"32'0"
  }

  coreArea.reg := in_
  val differ = in_ ^ coreArea.reg
  coreArea.result := coreArea.result | (differ & coreArea.reg)
  out_ := coreArea.result
}

object Edgecapture extends App {
  Config.spinal.generateVerilog(top_module())
}
