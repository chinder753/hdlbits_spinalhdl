package `3`.`2`.`1`.`7`

import spinal.core._
import config.Config

case class top_module() extends Component {
  val d, ena = in Bool ()
  val q = out Bool()
  q.noCombLoopCheck()

  when(ena){
    q := d
  }otherwise{
    q := q
  }
}

object M2014Q4a extends App {
  Config.spinal.generateVerilog(top_module())
}
