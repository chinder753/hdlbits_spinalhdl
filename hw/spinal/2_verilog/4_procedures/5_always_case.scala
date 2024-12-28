package `2`.`4`.`5`


import spinal.core._
import config.Config


case class top_module() extends Component{
  val sel = in Bits(3 bits)
  val data0 = in Bits(4 bits)
  val data1 = in Bits(4 bits)
  val data2 = in Bits(4 bits)
  val data3 = in Bits(4 bits)
  val data4 = in Bits(4 bits)
  val data5 = in Bits(4 bits)
  val out_ = out Bits(4 bits)

  out_ := sel.mux(
    0 -> data0,
    1 -> data1,
    2 -> data2,
    3 -> data3,
    4 -> data4,
    5 -> data5,
    default -> B"0000",
  )
}

object AlwaysCase extends App {
  Config.spinal.generateVerilog(top_module())
}
