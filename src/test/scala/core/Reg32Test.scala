package core
import org.scalatest._
import chiseltest._
import chisel3._
import chisel3.util._

class Reg32test extends FreeSpec with ChiselScalatestTester{
    "Register File"  in {
     test (new Reg32()){c =>
    c.io.imm_rs1.poke(1.U)
	c.io.imm_rs2.poke(3.U)
	c.io.rd_reg.poke(3.U)
    c.io.write_data.poke(58.S)
    c.io.reg_write.poke(1.U)

    c.clock.step(20)
    c.io.rs1_output.expect(0.S)
	c.io.rs2_output.expect(58.S)
        }
    }
}