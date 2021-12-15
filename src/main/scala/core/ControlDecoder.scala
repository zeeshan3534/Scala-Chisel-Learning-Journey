package core
import chisel3._
import chisel3.util._


class ControlDecoder extends Module{
	val io = IO(new Bundle{
		val RType = Input(UInt(1.W))
		val load = Input(UInt(1.W))
		val Store = Input(UInt(1.W))
		val SBType = Input(UInt(1.W))
		val IType = Input(UInt(1.W))
		val Jalr = Input(UInt(1.W))
		val Jal = Input(UInt(1.W))
		val Lui = Input(UInt(1.W))
		val auipc = Input(UInt(1.W))

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
 

		
		
	
		io.Branch := 0.U
        io.RegWrite := 0.U
        io.Immediate :=0.U
		io.Load := 0.U
        io.store := 0.U
        io.U_type :=0.U
        io.Auipc := 0.U
        io.jalr := 0.U
        io.jal := 0.U



        when(io.RType === 1.U){
			io.RegWrite := 1.U
		}.elsewhen(io.load === 1.U){
			
			io.RegWrite := 1.U
			io.Immediate := 1.U
			io.Load := 1.U
		}.elsewhen(io.Store === 1.U){
			io.Load := 1.U
			io.store := 1.U

		}.elsewhen(io.SBType === 1.U){
			io.Branch := 1.U

		}.elsewhen(io.IType === 1.U){
			io.RegWrite := 1.U
			io.Immediate := 1.U
		
		}.elsewhen(io.Jalr === 1.U){
			io.jalr := 1.U

		}.elsewhen(io.Jal === 1.U){
			io.RegWrite := 1.U
			io.jal := 1.U
			
		}.elsewhen(io.Lui === 1.U){
			io.RegWrite := 1.U
			io.Immediate:= 1.U
		}
        .elsewhen(io.auipc === 1.U){
            io.RegWrite := 1.U
            io.Auipc := 1.U
        }
}