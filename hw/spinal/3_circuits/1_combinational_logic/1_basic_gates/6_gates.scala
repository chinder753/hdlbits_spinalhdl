package `3`.`1`.`1`.`6`


import spinal.core._
import config.Config

case class top_module() extends Component{
    val a, b = in Bool()
    val out_and = out Bool()
    val out_or = out Bool()
    val out_xor = out Bool()
    val out_nand = out Bool()
    val out_nor = out Bool()
    val out_xnor = out Bool()
    val out_anotb = out Bool()

    out_and := a & b
    out_or := a | b
    out_xor := a ^ b

    
    out_nand := !(a & b)
    out_nor := !(a | b)
    out_xnor := !(a ^ b)

    out_anotb := a & (!b)
}

object Gates extends App{
    Config.spinal.generateVerilog(top_module())
}
