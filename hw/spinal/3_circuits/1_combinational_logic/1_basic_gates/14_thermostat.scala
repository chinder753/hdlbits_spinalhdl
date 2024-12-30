package `3`.`1`.`1`.`14`


import spinal.core._
import config.Config


case class top_module() extends Component{
    val too_cold, too_hot = in Bool()
    val mode, fan_on = in Bool()
    val heater, aircon, fan = out Bool()

    when(mode){
        heater := too_cold
        aircon := False
        fan := too_cold | fan_on
    }.otherwise{
        heater := False
        aircon := too_hot
        fan := too_hot | fan_on
    }
}

object Thermostat extends App{
    Config.spinal.generateVerilog(top_module())
}
