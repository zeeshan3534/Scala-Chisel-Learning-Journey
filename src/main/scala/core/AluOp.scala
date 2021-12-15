package core
import chisel3._
import chisel3.util._
import chisel3.core
import chisel3.util.experimental.loadMemoryFromFile

class AluOp extends Module{
	val io = IO(new Bundle{
		val Inst = Input(UInt(32.W))
        val branch = Input(Bool())
        val AluOut = Output(UInt(5.W))
})

     
    when (io.branch){
        io.AluOut := Cat(2.U,io.Inst(14,12))
    }.otherwise{
        io.AluOut := Cat(0.U,io.Inst(14,12),io.Inst(30))
    }
    
}