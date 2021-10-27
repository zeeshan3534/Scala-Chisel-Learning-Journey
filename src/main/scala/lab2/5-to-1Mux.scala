package lab2
import chisel3 . _
import chisel3 . util . _
class mux5_to_1 extends Module {
val io = IO (new Bundle {
    val a= Input(UInt(32.W))
    val sel = Input(UInt(3.W))
    val out = Output(Bool())
    })
    when(io.sel === 0.U){
        io.out := io.a(0.U)
    }.elsewhen(io.sel=== 1.U){
        io.out := io.a(8.U)
    }.elsewhen(io.sel===2.U){
        io.out := io.a(16.U)
    }.elsewhen(io.sel===3.U){
        io.out := io.a(24.U)
    }.otherwise{
        io.out := io.a(31.U)
    }
    }