package lab2
import org.scalatest._
import chiseltest._
import chisel3._

class mux5_to_1_Test extends FreeSpec with ChiselScalatestTester{
    "Mux 5_to_1" in {
        test(new mux5_to_1){ c=>
        c.io.a.poke(256.U)
        c.io.sel.poke(1.U)
       
        c.clock.step(20)
        
}}
}
