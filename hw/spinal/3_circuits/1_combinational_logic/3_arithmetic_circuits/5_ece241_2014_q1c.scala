package `3`.`1`.`3`.`5`


import spinal.core._
import config.Config

case class top_module() extends Component{
    this.setDefinitionName("top_module")

    val a, b = in Bits(8 bits)
    val s = out Bits(8 bits)
    val overflow = out Bool();

    var fadd_vec: Vector[`3`.`1`.`3`.`2`.top_module] = Vector()
    for(i <- 0 until 8){
        val fadd = `3`.`1`.`3`.`2`.top_module()
        fadd.setDefinitionName("fadd")
        fadd.a <> a(i)
        fadd.b <> b(i)
        fadd.sum <> s(i)
        fadd_vec = fadd_vec :+ fadd
    }

    fadd_vec(0).cin <> False
    for(i <- 0 until fadd_vec.length-1){
        fadd_vec(i+1).cin <> fadd_vec(i).cout
    }
    overflow <> Mux(a(7)^b(7), False, a(7)^fadd_vec.last.sum)
}

object Ece241_2014Q1c extends App{
    Config.spinal.generateVerilog(top_module())
}
