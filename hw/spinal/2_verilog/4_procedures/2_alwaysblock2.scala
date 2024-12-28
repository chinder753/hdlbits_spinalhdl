package `2`.`4`.`2`


import spinal.core._
import config.Config


case class top_module() extends Component{
  val a, b, clk = in Bool()
  val out_assign = out Bool()
  val out_always_comb = out Bool()
  val out_always_ff = out Bool()

  val coreClockDomain = ClockDomain(clk)
  val coreArea = new ClockingArea(coreClockDomain) {
    val regs = Reg(Bool())
  }

  val ab = a ^ b
  out_assign := ab
  out_always_comb := ab
  coreArea.regs := ab

  out_always_ff := coreArea.regs
}

object Alwaysblock2 extends App {
  Config.spinal.generateVerilog(top_module())
}
