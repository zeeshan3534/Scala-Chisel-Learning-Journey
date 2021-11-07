package lab2
import org.scalatest._
import chisel3._
import chiseltest._

class Mux_2to1_IO_test extends FreeSpec with ChiselScalatestTester{
    "Multiplexer" in {
        test(new Mux_2to1()){c=>
            c.io.in_A.poke(10.U)
            c.io.in_B.poke(20.U)
            c.io.select.poke(1.B)
            c.clock.step(20)
            //c.io.out.expect(20.U)
         
           
        }
    }
}
