package `2`.`5`.`5`


import spinal.core._
import config.Config

case class top_module() extends Component{
    val in_ = in Bits(255 bits)
    val out_ = out UInt(8 bits)

    var temp_val_list = (B"0"##in_).subdivideIn(2 bits).map((x: Bits) => {
        x(0).asUInt +^ x(1).asUInt
    }).toList

    while(temp_val_list.length != 2){
        println(temp_val_list.length)
        temp_val_list = temp_val_list.grouped(2).map((x: List[UInt]) => {
            x.reduce((p, x) => p +^ x)
        }).toList
    }

    out_ := temp_val_list(0) + temp_val_list(1)
}

object Popcount255 extends App{
    Config.spinal.generateVerilog(top_module())
}

