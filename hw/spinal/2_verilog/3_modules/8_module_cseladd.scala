package `2`.`3`.`8`


import spinal.core._
import config.Config

class add16() extends BlackBox{
    val a, b = in Bits(16 bits)
    val cin = in Bool()
    val sum = out Bits(16 bits)
    val cout = out Bool()
}

case class top_module() extends Component{
    val a, b = in Bits(32 bits)
    val sum = out Bits(32 bits)

    val ad1, ad2, ad3 = new add16()
    ad1.cin <> False
    ad1.a <> a(0, 16 bits)
    ad1.b <> b(0, 16 bits)

    ad2.cin <> False
    ad2.a <> a(16, 16 bits)
    ad2.b <> b(16, 16 bits)

    ad3.cin <> True
    ad3.a <> a(16, 16 bits)
    ad3.b <> b(16, 16 bits)

    sum := Mux(ad1.cout, ad3.sum, ad2.sum) ## ad1.sum
}

object ModuleCseladd extends App {
  Config.spinal.generateVerilog(top_module())
}
