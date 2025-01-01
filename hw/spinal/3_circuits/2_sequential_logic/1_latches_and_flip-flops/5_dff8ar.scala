package `3`.`2`.`1`.`5`

import spinal.core._
import config.Config

case class top_module() extends Component {
  val clk, areset = in Bool()
  val d = in Bits (8 bits)
  val q = out Bits (8 bits)

  val coreClockDomain = ClockDomain(clk, areset)
  val coreArea = new ClockingArea(coreClockDomain){
    val reg = Reg(Bits(8 bits)) init B"x00"
  }

coreArea.reg := d
  q := coreArea.reg
}

object Dff8ar extends App {
  Config.spinal.generateVerilog(top_module())
}
