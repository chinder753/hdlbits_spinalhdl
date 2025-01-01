package `3`.`2`.`1`.`14`

import spinal.core._
import config.Config

case class top_module() extends Component {
  val clk, j, k = in Bool ()
  val Q = out Bool()


  val coreClockDomian = ClockDomain(clk)
  val coreArea = new ClockingArea(coreClockDomian){
    val reg = Reg(Bool())
  }

  when(j^k){
    coreArea.reg := j
  }otherwise{
    coreArea.reg := Mux(j, !coreArea.reg, coreArea.reg)
  }

  Q := coreArea.reg
}

object Ece241_2013Q7 extends App {
  Config.spinal.generateVerilog(top_module())
}
