package lab2 
import chisel3._
import chisel3.util._
class Encoder69 extends Module {
val io = IO ( new Bundle {
val in0 = Input(UInt(32.W))
val in1 = Input(UInt(32.W))
val in2 = Input(UInt(32.W))
val in3 = Input(UInt(32.W))
val sel1 = Input(UInt(2.W))
val out1 = Output(UInt(32.W))
val out2 = Output(UInt(32.W))
})
io.out1 := Mux1H ( io.sel1 , Seq ( io.in0 , io.in1 ) )
io.out2 :=Mux1H (io.sel1, Seq (io.in2 , io.in3 ))
}

