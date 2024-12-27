package `1`.`1`


import spinal.core._
import config.Config

case class top_module() extends Component {
  val one = out Bool()
  one := True
}

object StepOne extends App {
  Config.spinal.generateVerilog(top_module())
}

