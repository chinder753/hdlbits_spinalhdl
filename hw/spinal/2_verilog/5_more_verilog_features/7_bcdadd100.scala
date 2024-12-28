package `2`.`5`.`7`


import spinal.core._
import config.Config

case class bcd_fadd() extends BlackBox{
    val a, b = in Bits(4 bits)
    val cin = in Bool()
    val cout = out Bool()
    val sum = out Bits(4 bits)
}

case class top_module() extends Component{
    val a, b = in Bits(400 bits)
    val cin = in Bool()
    val cout = out Bool()
    val sum = out Bits(400 bits)

    val (remain_a, first_a) = a.splitAt(4)
    val (remain_b, first_b) = b.splitAt(4)
    val first_bcd = bcd_fadd()
    first_bcd.a := first_a
    first_bcd.b := first_b
    first_bcd.cin := cin
    sum(0, 4 bits) := first_bcd.sum

    var bcd_vec: Vector[bcd_fadd] = Vector(first_bcd)
    remain_a.subdivideIn(4 bits)
        .zip(remain_b.subdivideIn(4 bits))
        .zipWithIndex.foreach(
            (temp) => {
                val ((a, b), i) = temp
                val temp_bcd = bcd_fadd()
                temp_bcd.a := a
                temp_bcd.b := b
                temp_bcd.cin := bcd_vec.last.cout
                sum(i*4+4, 4 bits) := temp_bcd.sum
                bcd_vec = bcd_vec :+ temp_bcd
            }
        )
    
    cout := bcd_vec.last.cout
}

object Bcdadd100 extends App{
    Config.spinal.generateVerilog(top_module())
}

