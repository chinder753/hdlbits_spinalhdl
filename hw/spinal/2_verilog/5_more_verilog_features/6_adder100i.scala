package `2`.`5`.`6`


import spinal.core._
import config.Config

case class top_module() extends Component{
    val a, b = in Bits(100 bits)
    val cin = in Bool()
    val cout, sum = out UInt(100 bits)

    val temp_cout = Vec(Bool(), 100)
    def adder(i: Int, cin: Bool){
        (temp_cout(i), sum(i)) := (a(i).asUInt +^ b(i).asUInt) + cin.asUInt
    }

    adder(0, cin)
    for(i <- 1 until 100){
        adder(i, temp_cout(i-1))
    }

    cout := temp_cout.asBits.asUInt
}

object Adder100i extends App{
    Config.spinal.generateVerilog(top_module())
}

