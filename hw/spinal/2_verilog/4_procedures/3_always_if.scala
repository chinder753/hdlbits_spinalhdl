package `2`.`4`.`3`


import spinal.core._
import config.Config


case class top_module() extends Component{
  val a, b, sel_b1, sel_b2, clk = in Bool()
  val out_assign = out Bool()
  val out_always = out Bool()

  val output = (sel_b1##sel_b2).mux(
    3 -> b,
    default -> a,
  )

  out_assign := output
  out_always := output
}

object AlwaysIf extends App {
  Config.spinal.generateVerilog(top_module())
}
