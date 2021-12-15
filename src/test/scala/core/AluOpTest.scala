package core
import org.scalatest._
import chiseltest._
import chisel3._
import chisel3.util._

class AluOpTest extends FreeSpec with ChiselScalatestTester{
    "Aluop"  in {
     test (new AluOp()){ c =>
        c.io.Inst.poke(0.U)     
        c.io.branch.poke(1.B)    
        c.clock.step(10)
        // c.io.AluOut.expect(7.U)
        }
    }
}   