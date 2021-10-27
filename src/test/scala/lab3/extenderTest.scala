package lab3
import org.scalatest._
import chiseltest._
import chisel3._

class AndTest extends FreeSpec with ChiselScalatestTester{
    "BitExtender" in {
        test (new Extender){ c =>
        c.io.Instruction.poke(32500.S)
        c.io.PC.poke(32.S)
        c.io.opcode.poke(99.U)



           
        // c.io.out(1).expect(1.B)
        c.clock.step(10)
        }
    }
}
