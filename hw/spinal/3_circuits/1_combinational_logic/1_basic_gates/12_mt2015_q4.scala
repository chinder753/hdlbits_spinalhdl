package `3`.`1`.`1`.`12`


import spinal.core._
import config.Config


case class top_module() extends Component{
    this.setDefinitionName("top_module")
    
    val x, y = in Bool()
    val z = out Bool()

    val IA1 = `3`.`1`.`1`.`10`.top_module()
    val IA2 = `3`.`1`.`1`.`10`.top_module()
    val IB1 = `3`.`1`.`1`.`11`.top_module()
    val IB2 = `3`.`1`.`1`.`11`.top_module()
    IA1.setDefinitionName("A")
    IB1.setDefinitionName("B")
    

    IA1.x <> x
    IA2.x <> x
    IB1.x <> x
    IB2.x <> x

    IA1.y <> y
    IA2.y <> y
    IB1.y <> y
    IB2.y <> y

    val R1 = IA1.z | IB1.z
    val R2 = IA2.z & IB2.z

    z := R1 ^ R2
}

object Mt2015Q4 extends App{
    Config.spinal.generateVerilog(top_module())
}
