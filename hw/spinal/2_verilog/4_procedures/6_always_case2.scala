package `2`.`4`.`6`


import spinal.core._
import config.Config


case class top_module() extends Component{
  val in_ = in Bits(4 bits)
  val pos = out Bits(2 bits)

  def find_pos(num: Int): Bits = {
      var i = 0
      if(num!=0){
        var num_temp = num
        while((num_temp&1) == 0){
          i += 1
          num_temp >>= 1
        }
      }
      val i_str = i.toBinaryString
      return B(f"2'$i_str")
  }

  pos := in_.muxList(
    for (index <- 0 until 16) yield (index, find_pos(index))
  )
}

object AlwaysCase2 extends App {
  Config.spinal.generateVerilog(top_module())
}
