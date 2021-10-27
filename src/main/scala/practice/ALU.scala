package practice
import chisel3._
import chisel3.util._

class ArthmeticlogicUnit extends Module{
    val io = IO (new Bundle{
        val in_1 = Input (UInt(32.W))
        val in_2 = Input (UInt(32.W))
        val select = Input(UInt(5.W))
        val output = Output(UInt(32.W))
        val out2 = Output(Bool())
    })
    io.output := 0.U
    switch(io.select){
        is (0.U){
            io.output := io.in_1 + io.in_2
        }
        //sll
        is (1.U){
            io.output := io.in_1 << io.in_2(4,0)
        }
        //SLT
        is (2.U){
            when(io.in_1 < io.in_2){
                io.output:= 1.U
            }.otherwise{
                io.output:=0.U
            }
        
        }
        //BLT
        is (3.U){
            when(io.in_1 < io.in_2){
                io.output:= 1.U
            }.otherwise{
                io.output:=0.U
            }
        }
        //xor
        is(4.U){
            io.output:=io.in_1^io.in_2
        }
        //slr
        is(5.U){
            io.output:=io.in_1 >> io.in_2(4,0)
        }
        //or
        is(6.U){
            io.output:=io.in_1 | io.in_2
            
        }
        //ANd
        is(7.U){
            io.output:=io.in_1 & io.in_2
        }
        //sub
         is(8.U){
            io.output:=io.in_1 - io.in_2
        }
        //SRA
        is(13.U){
 
              io.output := io.in_1 >> io.in_2(4,0)

        }
        //BEQ
        is(16.U){
            when(io.in_1 === io.in_2){
                io.output:= 1.U
            }.otherwise{
                io.output:=0.U
            }
        }
        //bne
        is(17.U){
            when(io.in_1 =/= io.in_2){
                io.output:= 1.U
            }.otherwise{
                io.output:=0.U
            }
        }
        //bge
        is(21.U){
            when(io.in_1 >= io.in_2){
                io.output:= 1.U
            }.otherwise{
                io.output:=0.U
            }
        }
        //blt
        is(20.U){
            when(io.in_1 < io.in_2){
                io.output:= 1.U
            }.otherwise{
                io.output:=0.U
            }
        }

    }
    when (io.output === 1.U & io.select(4,3) === "b10".U){
        io.out2 := 1.U
    }.otherwise{
        io.out2 := 0.U
    }
    
    

}
