package core
import org.scalatest._
import chiseltest._
import chisel3._
import chisel3.util._

class instructionmemorytest extends FreeSpec with ChiselScalatestTester{
    "InstructionMemory"  in {
     test (new InsMemory()){ c =>
        c.io.write_address.poke(0.U)         
        c.clock.step(10)
        }
    }
}