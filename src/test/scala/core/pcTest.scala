package core
import org.scalatest._
import chiseltest._
import chisel3._
import chisel3.util._

class pctest extends FreeSpec with ChiselScalatestTester{
    "pc"  in {
     test (new PC()){ c =>
        c.io.input.poke(0.U)         
        c.clock.step(10)
        }
    }
}