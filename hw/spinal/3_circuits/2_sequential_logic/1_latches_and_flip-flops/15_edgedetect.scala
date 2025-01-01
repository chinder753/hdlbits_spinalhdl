package `3`.`2`.`1`.`15`

import spinal.core._
import config.Config

case class top_module() extends Component {
  val clk = in Bool()
  val in_ = in Bits(8 bits)
  val pedge = out Bits(8 bits)

  val coreClockDomian = ClockDomain(clk)
  val coreArea = new ClockingArea(coreClockDomian){
    val reg = Reg(Bits(8 bits))
    val differ = Reg(Bits(8 bits))
  }

  coreArea.reg := in_
  coreArea.differ := in_ ^ coreArea.reg
  when(coreArea.differ.orR){
    pedge := coreArea.differ & coreArea.reg
  }otherwise{
    pedge := B"8'0"
  }
}

object Edgedetect extends App {
  Config.spinal.generateVerilog(top_module())
}
