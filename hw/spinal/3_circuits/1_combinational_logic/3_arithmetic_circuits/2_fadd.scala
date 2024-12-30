package `3`.`1`.`3`.`2`


import spinal.core._
import config.Config

case class top_module() extends Component{
    this.setDefinitionName("top_module")

    val a, b, cin = in Bool()
    val cout, sum = out Bool()

    val hadd1 = `3`.`1`.`3`.`1`.top_module()
    val hadd2 = `3`.`1`.`3`.`1`.top_module()
    hadd1.setDefinitionName("hadd")

    hadd1.a <> a
    hadd1.b <> b

    hadd2.a <> cin
    hadd2.b <> hadd1.sum

    sum := hadd2.sum
    cout := hadd1.cout | hadd2.cout

}

object Fadd extends App{
    Config.spinal.generateVerilog(top_module())
}
