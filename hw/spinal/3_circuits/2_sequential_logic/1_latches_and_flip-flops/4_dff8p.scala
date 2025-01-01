package `3`.`2`.`1`.`4`

import spinal.core._
import config.Config

case class top_module() extends Component {
  val clk, reset = in Bool()
  val d = in Bits (8 bits)
  val q = out Bits (8 bits)

  val coreClockDomain = ClockDomain(clk, reset, config = ClockDomainConfig(FALLING, SYNC))
  val coreArea = new ClockingArea(coreClockDomain){
    val reg = Reg(Bits(8 bits)) init B"x34"
  }

coreArea.reg := d
  q := coreArea.reg
}

object Dff8p extends App {
  Config.spinal.generateVerilog(top_module())
}
