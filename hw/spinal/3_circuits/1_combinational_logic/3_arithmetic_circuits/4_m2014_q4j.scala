package `3`.`1`.`3`.`4`


import spinal.core._
import config.Config

case class top_module() extends Component{
    this.setDefinitionName("top_module")

    val x, y = in Bits(4 bits)
    val sum = out Bits(5 bits)

    val fadd1 = `3`.`1`.`3`.`2`.top_module()
    val fadd2 = `3`.`1`.`3`.`2`.top_module()
    val fadd3 = `3`.`1`.`3`.`2`.top_module()
    val fadd4 = `3`.`1`.`3`.`2`.top_module()

    List(fadd1, fadd2, fadd3, fadd4)
        .zipWithIndex
        .foreach(
            (temp) => {
                val (fadd, i) = temp
                fadd.setDefinitionName("fadd")
                fadd.a <> x(i)
                fadd.b <> y(i)
                fadd.sum <> sum(i)
            }
        )

    fadd1.cin <> False
    fadd2.cin <> fadd1.cout
    fadd3.cin <> fadd2.cout
    fadd4.cin <> fadd3.cout
    sum(4) := fadd4.cout
}

object M2014Q4j extends App{
    Config.spinal.generateVerilog(top_module())
}
