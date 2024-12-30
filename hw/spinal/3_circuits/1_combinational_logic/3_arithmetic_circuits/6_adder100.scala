package `3`.`1`.`3`.`6`


import spinal.core._
import config.Config

case class top_module(num: Int) extends Component{
    this.setDefinitionName("top_module")

    val a, b = in Bits(num bits)
    val cin = in Bool();
    val sum = out Bits(num bits)
    val cout = out Bool();

    var fadd_vec: Vector[`3`.`1`.`3`.`2`.top_module] = Vector()
    for(i <- 0 until num){
        val fadd = `3`.`1`.`3`.`2`.top_module()
        fadd.setDefinitionName("fadd")
        fadd.a <> a(i)
        fadd.b <> b(i)
        fadd.sum <> sum(i)
        fadd_vec = fadd_vec :+ fadd
    }

    fadd_vec(0).cin <> cin
    for(i <- 0 until fadd_vec.length-1){
        fadd_vec(i+1).cin <> fadd_vec(i).cout
    }
    cout <> fadd_vec.last.cout
}

object Adder100 extends App{
    Config.spinal.generateVerilog(top_module(100))
}
