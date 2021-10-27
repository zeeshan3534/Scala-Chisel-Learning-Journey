package lab2
import chisel3._
import chisel3.util._

class barrel_shift extends Module {
    val io = IO ( new Bundle {
        val in = Vec (4 , Input ( Bool () ) )
        val sel = Vec (2 , Input ( Bool () ) )
        val shift_type = Input ( Bool () )
        val out = Vec (4 , Output ( Bool () ) )
    })
    val m1= Mux(io.shift_type,io.in(0),0.B)
    val m2= Mux(io.shift_type,io.in(1),0.B)
    val m3= Mux(io.shift_type,io.in(2),0.B)

    io.out(0) := Mux (io.sel(1),Mux (io.sel(0) ,io.in(3),io.in(2)),Mux (io.sel(0),io.in(1),io.in(0)))
    io.out(1) := Mux (io.sel(1),Mux (io.sel(0) ,m1,io.in(3)),Mux (io.sel(0),io.in(2),io.in(1)))
    io.out(2) := Mux (io.sel(1),Mux (io.sel(0) ,m2,m1),Mux (io.sel(0),io.in(3),io.in(2)))
    io.out(3) := Mux (io.sel(1),Mux (io.sel(0) ,m3,m2),Mux (io.sel(0),m1,io.in(3)))
    
// Start you code here
// End your code here
}