package core
import chisel3._
import chisel3.util._


class ControlUnit extends Module{
	val io = IO(new Bundle{
		val opcode = Input(UInt(7.W))


		val Branch = Output(UInt(1.W))
		val RegWrite = Output(UInt(1.W))
		val Immediate = Output(UInt(1.W))
		val Load = Output(UInt(1.W))
		val store = Output(UInt(1.W))
		val U_type = Output(UInt(1.W))
		val Auipc = Output(UInt(1.W))
		val jalr = Output(UInt(1.W))
		val jal = Output(UInt(1.W))
	})
    


    val tdeco = Module (new TypeDecoder())
    val cdec = Module (new ControlDecoder())
    
    tdeco.io.opCode := io.opcode


    cdec.io.RType := tdeco.io.RType
    cdec.io.load := tdeco.io.Load
    cdec.io.Store := tdeco.io.Store
    cdec.io.SBType := tdeco.io.Branch
    cdec.io.IType := tdeco.io.IType
    cdec.io.Jalr := tdeco.io.Jalr
    cdec.io.Jal := tdeco.io.Jal
    cdec.io.Lui := tdeco.io.Lui
    cdec.io.auipc := tdeco.io.auipc


    io.Branch := cdec.io.Branch
    io.RegWrite :=cdec.io.RegWrite
    io.Immediate := cdec.io.Immediate
    io.Load := cdec.io.Load
    io.store := cdec.io.store
    io.U_type := cdec.io.U_type
    io.Auipc := cdec.io.Auipc
    io.jalr :=cdec.io.jalr
    io.jal :=cdec.io.jal
}
