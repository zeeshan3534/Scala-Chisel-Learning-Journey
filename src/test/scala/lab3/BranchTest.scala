package labs
import org.scalatest._
import chisel3._
import chiseltest._

class Branchtest extends FreeSpec with ChiselScalatestTester{
    "Branch " in {
        test(new Branch()){c=>
        c.io.a.poke(1.S)
        c.io.b.poke(2.S)
        c.io.sel.poke(19.U)
        c.io.branch.poke(1.B)
        c.clock.step(1)
        
        }
    }
}