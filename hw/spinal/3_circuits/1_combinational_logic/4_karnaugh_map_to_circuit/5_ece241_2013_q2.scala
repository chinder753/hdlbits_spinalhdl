package `3`.`1`.`4`.`5`


import spinal.core._
import config.Config

case class top_module() extends Component{
    val a, b, c, d = in Bool()
    val out_sop, out_pos = out Bool()

/* 
    CD  00  01  10  11
  AB
  00    0   1   2   3
  01    4   5   6   7
  10    8   9   10  11
  11    12  13  14  15

      00  01  10  11
  00  0   0   1   b
  01  0   0   0   1
  10  b   0   0   b 
  11  b   0   0   1

      00  01  10  11
  00  0   0   1   1
  01  0   0   0   1
  10  b   0   0   1 
  11  b   0   0   1

 */

    // out_sop := ((c)&(!d)&(!a)&(!b)) | ((c)&(d)&(b))

    // 0011 = 1
    // out_sop := (c)&(!a)&(!b) | (c)&(d)&(b)

    // 1011 = 1
    out_sop := (c)&(d) | (c)&(!d)&(!a)&(!b)

    out_pos := out_sop
}

object Ece241_2013Q2 extends App{
    Config.spinal.generateVerilog(top_module())
}
