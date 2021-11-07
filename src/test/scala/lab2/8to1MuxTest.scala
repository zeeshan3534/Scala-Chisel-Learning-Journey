package lab2
import org.scalatest._
import chiseltest._
import chisel3._

class MuxLoopupTest extends FreeSpec with ChiselScalatestTester{
    "some test" in {
        test(new MuxLookup){ c=>
        c.io.in0.poke(0.B)
        c.io.in1.poke(0.B)
        c.io.in2.poke(1.B)
        c.io.in3.poke(0.B)
        c.io.in4.poke(0.B)
        c.io.in5.poke(0.B)
        c.io.in6.poke(0.B)
        c.io.in7.poke(0.B)
        c.io.sel.poke(0.B)
        c.io.sel1.poke(2.U)
        c.clock.step(20)
        
}}
}
