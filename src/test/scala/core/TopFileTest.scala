package core
import org.scalatest._
import chiseltest._
import chisel3._
import chisel3.util._

class MainTest extends FreeSpec with ChiselScalatestTester{
    "TopFile"  in {
     test (new Main()){ c =>
        // c.io.Inst.poke(0.U)     
        // c.io.branch.poke(1.B)    
        c.clock.step(10)
        // c.io.AluOut.expect(7.U)
        }
    }
}   