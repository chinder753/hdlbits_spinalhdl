package `3`.`1`.`1`.`13`


import spinal.core._
import config.Config


case class top_module() extends Component{
    val ring, vibrate_mode = in Bool()
    val ringer, motor = out Bool()

    (ringer, motor) := (ring##vibrate_mode).mux(
        B"10" -> B"10",
        B"11" -> B"01",
        default -> B"00"
    )
}

object Ringer extends App{
    Config.spinal.generateVerilog(top_module())
}
