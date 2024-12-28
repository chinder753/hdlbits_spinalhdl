package `2`.`4`.`4`


import spinal.core._
import config.Config


case class top_module() extends Component{
  val cpu_overheated = in Bool()
  val shut_off_computer = out Bool()

  val arrived = in Bool()
  val gas_tank_empty = in Bool()
  val keep_driving = out Bool()

  shut_off_computer := Mux(cpu_overheated, True, False)
  keep_driving := Mux(arrived | gas_tank_empty, False, True)
}

object AlwaysIf2 extends App {
  Config.spinal.generateVerilog(top_module())
}
