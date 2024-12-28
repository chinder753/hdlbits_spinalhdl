package `2`.`4`.`7`


import spinal.core._
import config.Config


case class top_module() extends Component{
  val in_ = in Bits(8 bits)
  val pos = out Bits(3 bits)

  pos := in_.mux(
    M"----_---1" -> B"000",
    M"----_--10" -> B"001",
    M"----_-100" -> B"010",
    M"----_1000" -> B"011",
    M"---1_0000" -> B"100",
    M"--10_0000" -> B"101",
    M"-100_0000" -> B"110",
    B"1000_0000" -> B"111",
    default -> B"000",
  )
}

object AlwaysCasez extends App {
  Config.spinal.generateVerilog(top_module())
}
