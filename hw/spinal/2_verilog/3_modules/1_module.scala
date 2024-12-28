package `2`.`3`.`1`


import spinal.core._
import config.Config

class mod_a() extends BlackBox{
    val in1, in2 = in Bool()
    val out_ = out Bool()
}

case class top_module() extends Component{
    val a, b = in Bool()
    val out_ = out Bool()

    val ma = new mod_a()
    a <> ma.in1
    b <> ma.in2
    out_ <> ma.out_
}

object Module extends App {
  Config.spinal.generateVerilog(top_module())
}
