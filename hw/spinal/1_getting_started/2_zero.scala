package `1`.`2`


import spinal.core._
import config.Config

// Hardware definition
case class top_module() extends Component {
  val zero = out Bool()
  zero := False
}

object Zero extends App {
  Config.spinal.generateVerilog(top_module())
}

