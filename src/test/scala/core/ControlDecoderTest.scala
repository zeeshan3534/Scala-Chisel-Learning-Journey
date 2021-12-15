package core
import org.scalatest._
import chiseltest._
import chisel3._
import chisel3.util._

class ControlDecodertest extends FreeSpec with ChiselScalatestTester{
    "Control Decoder"  in {
     test (new ControlDecoder()){ c =>
        c.io.load.poke(1.U)         
        c.clock.step(10)
        }
    }
}