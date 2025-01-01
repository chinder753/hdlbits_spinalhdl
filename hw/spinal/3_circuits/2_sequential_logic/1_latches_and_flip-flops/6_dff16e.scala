package `3`.`2`.`1`.`6`

import spinal.core._
import config.Config

case class top_module() extends Component {
  val clk, resetn = in Bool ()
  val byteena = in Bits (2 bits)
  val d = in Bits (16 bits)
  val q = out Bits (16 bits)

  val coreClockDomain = ClockDomain(clk, resetn, config = ClockDomainConfig(resetKind = SYNC, resetActiveLevel = LOW))
  val coreArea = new ClockingArea(coreClockDomain) {
    val reg = Reg(Bits(16 bits)) init B"x0000"
  }

  when(byteena(0)){
    coreArea.reg(0, 8 bits) := d(0, 8 bits)
  }

  when(byteena(1)){
    coreArea.reg(8, 8 bits) := d(8, 8 bits)
  }

  q := coreArea.reg
}

object Dff16e extends App {
  Config.spinal.generateVerilog(top_module())
}
