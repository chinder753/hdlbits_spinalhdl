package `2`.`2`.`3`


import spinal.core._
import config.Config

case class top_module() extends Component{
    val in_ = in Bits(32 bits)
    val out_ = out Bits(32 bits)

    for(i <- Array.range(0, 32, 8)){
      out_(i, 8 bits) := in_(24-i, 8 bits)
    }
}

object Vector2 extends App {
  Config.spinal.generateVerilog(top_module())
}
