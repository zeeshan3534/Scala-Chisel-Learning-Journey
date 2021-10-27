package practice
import org.scalatest._
import chiseltest._
import chisel3._

class ALUTest extends FreeSpec with ChiselScalatestTester{
    "AluVcd" in  {
        test (new ArthmeticlogicUnit()){ c =>
        c.io.in_1.poke(12.U)
        c.io.in_2.poke(12.U)
      
        c.io.select.poke(16.U)
        c.io.output.expect(1.U) 
        c.io.out2.expect(1.B)     
        // c.io.out(1).expect(1.B)
        c.clock.step(100)
        }
    }
} 