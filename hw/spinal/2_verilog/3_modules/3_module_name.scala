package `2`.`3`.`3`


import spinal.core._
import config.Config


class mod_a() extends BlackBox{
    val in1, in2, in3, in4 = in Bool()
    val out1, out2 = out Bool()
}

case class top_module() extends Component{
    val a, b, c, d = in Bool()
    val out1, out2 = out Bool()

    val ma = new mod_a()
    a <> ma.in1
    b <> ma.in2
    c <> ma.in3
    d <> ma.in4
    out1 <> ma.out1
    out2 <> ma.out2
}

object Module extends App {
  Config.spinal.generateVerilog(top_module())
}
