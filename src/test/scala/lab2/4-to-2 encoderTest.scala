package lab2
import org.scalatest._
import chiseltest._
import chisel3._

class EncoderTest extends FreeSpec with ChiselScalatestTester{
    "Encoder" in {
        test(new Encoder69){ c=>
        c.io.in0.poke(21.U)
        c.io.in1.poke(11.U)
        c.io.in2.poke(51.U)
        c.io.in3.poke(31.U)
        c.io.sel1.poke(2.U)
        
       
        c.clock.step(20)
        
}}
}
