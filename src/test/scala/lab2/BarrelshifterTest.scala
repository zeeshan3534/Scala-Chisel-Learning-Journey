package lab2
import org.scalatest._
import chiseltest._
import chisel3._

class barrel_shift_Test extends FreeSpec with ChiselScalatestTester{
    "Mux Barrel Shift" in  {
        test (new barrel_shift()){ c =>
        c.io.in(0).poke(1.B)
        c.io.in(1).poke(0.B)
        c.io.in(2).poke(0.B)
        c.io.in(3).poke(0.B) 
        c.io.sel(0).poke(1.B)
        c.io.sel(1).poke(1.B)
        c.io.shift_type.poke(0.B)
        //c.io.out.expect(3.U)      
        // c.io.out(1).expect(1.B)
        c.clock.step(100)
        }
    }
}
