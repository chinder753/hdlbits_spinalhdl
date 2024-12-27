package `2`.`1`.`7`


import spinal.core._
import config.Config

case class top_module() extends Component{
    val a, b, c, d = in Bool()
    val out_, out_n = out Bool()

    val ab = a & b
    val cd = c & d
    val abcd = ab | cd
    out_ := abcd
    out_n := !abcd
}

object WireDecl extends App {
  Config.spinal.generateVerilog(top_module())
}
