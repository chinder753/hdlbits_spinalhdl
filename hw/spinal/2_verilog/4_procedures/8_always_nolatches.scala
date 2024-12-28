package `2`.`4`.`8`


import spinal.core._
import config.Config


case class top_module() extends Component{
  val scancode = in Bits(16 bits)
  val left, down, right, up = out Bool()

  left := False
  down := False
  right := False
  up := False
  switch(scancode){
    is(B"16'he06b"){
      left := True
    }
    is(B"16'he072"){
      down := True
    }
    is(B"16'he074"){
      right := True
    }
    is(B"16'he075"){
      up := True
    }
  }
}

object AlwaysNolatches extends App {
  Config.spinal.generateVerilog(top_module())
}
