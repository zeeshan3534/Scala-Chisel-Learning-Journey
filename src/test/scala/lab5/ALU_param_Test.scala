package practice
import org.scalatest._
import chiseltest._
import chisel3._
import scala.util.Random

class AndTest extends FreeSpec with ChiselScalatestTester{
    "ALUpara" in {
        test(new ALU(32)){ c=>
        for (i<-0 until 50){
        val src_a = Random.nextLong()& 0xFFFFFFFFL
        val src_b = Random.nextLong()& 0xFFFFFFFFL
        val aluop = Random.nextInt(9)
        c.io.arg_x.poke(src_a.U)
        c.io.arg_y.poke(src_b.U)
        c.io.alu_oper.poke(aluop.U)
        c.clock.step(1)
        // c.io.sel.poke(1.U)
        }
        c.clock.step(50)
        
}}
}