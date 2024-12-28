package `2`.`3`.`7`


import spinal.core._
import config.Config

case class add1() extends Component{
    val a, b, cin = in UInt(1 bits)
    val sum, cout = out UInt(1 bits)

    (cout, sum) := (a +^ b) + cin
}

class add16() extends BlackBox{
    val a, b = in Bits(16 bits)
    val cin = in Bool()
    val sum = out Bits(16 bits)
    val cout = out Bool()
}

case class top_module() extends Component{
    val a, b = in Bits(32 bits)
    val sum = out Bits(32 bits)

    val ad1, ad2 = new add16()
    ad1.cin <> False
    ad1.a <> a(0, 16 bits)
    ad1.b <> b(0, 16 bits)

    ad2.cin <> ad1.cout
    ad2.a <> a(16, 16 bits)
    ad2.b <> b(16, 16 bits)

    sum := ad2.sum ## ad1.sum
}

object ModuleFadd extends App {
  Config.spinal.generateVerilog(add1())
  Config.spinal.generateVerilog(top_module())
}
