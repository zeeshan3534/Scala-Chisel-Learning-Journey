package core
import chisel3._
import chisel3.util._
//import chisel3.util.Fill
import chisel3.util.experimental.loadMemoryFromFile


class InsMemory extends Module{
	val io = IO(new Bundle{

		val write_address = Input(UInt(10.W)) 
		val r_data = Output(UInt(32.W))

})
		val mem =Mem(1024,UInt(32.W))

		io.r_data := mem(io.write_address)
		loadMemoryFromFile(mem,"/home/zeeboiii/Documents/doc.txt")
	
}