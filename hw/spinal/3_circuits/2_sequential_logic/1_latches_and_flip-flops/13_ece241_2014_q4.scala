package `3`.`2`.`1`.`13`

import spinal.core._
import config.Config

case class MyLatch() extends Component{
  val clk, d = in Bool()
  val q, q_n = out Bool()

  val coreClockDomian = ClockDomain(clk)
  val coreArea = new ClockingArea(coreClockDomian){
    val latch = Reg(Bool())
  }

  coreArea.latch := d
  q := coreArea.latch
  q_n := !coreArea.latch
}

case class top_module() extends Component {
  val clk, x = in Bool ()
  val z = out Bool()


  val coreClockDomian = ClockDomain(clk)
  val coreArea = new ClockingArea(coreClockDomian){
    val latch1 = MyLatch()
    val latch2 = MyLatch()
    val latch3 = MyLatch()
    latch1.clk <> clk
    latch2.clk <> clk
    latch3.clk <> clk
  }

  coreArea.latch1.d <> (x ^ coreArea.latch1.q)
  coreArea.latch2.d <> (x & coreArea.latch2.q_n)
  coreArea.latch3.d <> (x | coreArea.latch3.q_n)

  z <> !(coreArea.latch1.q | coreArea.latch2.q | coreArea.latch3.q)
}

object Ece241_2014Q4 extends App {
  Config.spinal.generateVerilog(top_module())
}
