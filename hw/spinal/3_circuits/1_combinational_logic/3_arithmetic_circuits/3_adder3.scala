package `3`.`1`.`3`.`3`


import spinal.core._
import config.Config

case class top_module() extends Component{
    this.setDefinitionName("top_module")

    val a, b = in Bits(3 bits)
    val cin = in Bool()
    val cout, sum = out Bits(3 bits)

    val fadd1 = `3`.`1`.`3`.`2`.top_module()
    val fadd2 = `3`.`1`.`3`.`2`.top_module()
    val fadd3 = `3`.`1`.`3`.`2`.top_module()

    List(fadd1, fadd2, fadd3)
        .zipWithIndex
        .foreach(
            (temp) => {
                val (fadd, i) = temp
                fadd.setDefinitionName("fadd")
                fadd.a <> a(i)
                fadd.b <> b(i)
                fadd.sum <> sum(i)
                fadd.cout <> cout(i)
            }
        )

    fadd1.cin <> cin
    fadd2.cin <> fadd1.cout
    fadd3.cin <> fadd2.cout
}

object Adder3 extends App{
    Config.spinal.generateVerilog(top_module())
}
