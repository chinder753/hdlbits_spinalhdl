package `3`.`1`.`3`.`7`


import spinal.core._
import config.Config

case class bcd_fadd() extends BlackBox{
    val a, b = in Bits(4 bits)
    val cin = in Bool()
    val sum = out Bits(4 bits)
    val cout = out Bool()
} 

case class top_module(num: Int) extends Component{
    val a, b = in Bits(16 bits)
    val cin = in Bool()
    val sum = out Bits(16 bits)
    val cout = out Bool()

    var bcd_fadd_vec: Vector[bcd_fadd] = Vector();
    for(i <- 0 until 4){
        val fadd = bcd_fadd()
        bcd_fadd_vec = bcd_fadd_vec :+ fadd

        fadd.a <> a(i*4, 4 bits)
        fadd.b <> b(i*4, 4 bits)
        fadd.sum <> sum(i*4, 4 bits)
    }

    bcd_fadd_vec(0).cin <> cin
    for(i <- 0 until 3){
        bcd_fadd_vec(i+1).cin <> bcd_fadd_vec(i).cout
    }
    cout <> bcd_fadd_vec.last.cout
}

object Bcdadd4 extends App{
    Config.spinal.generateVerilog(top_module(100))
}
