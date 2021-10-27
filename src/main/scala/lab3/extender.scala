package lab3
import chisel3._
import chisel3.util._


class Extender extends Module{
    val io = IO (new Bundle{
        val opcode = Input(UInt(7.W))
        val Instruction = Input(SInt(32.W))
        val PC = Input(SInt(32.W))
        val out =Output(SInt(32.W))

    })
    
    //I type
    when(io.opcode === 19.U){
        io.out := io.Instruction(31,20).asSInt
        
    } 
    //B Type  
    .elsewhen(io.opcode === 99.U){
        
        
       io.out := ((Cat(io.Instruction(31),io.Instruction(7),io.Instruction(30,25),io.Instruction(11,8),0.U)).asSInt + io.PC)
         
    }  
    //  U Type 
    .elsewhen(io.opcode === 55.U){
                
        io.out := io.Instruction(31,12).asSInt
    }  
     //Jal Type 
    .elsewhen(io.opcode === 111.U){
        
        io.out := (((Cat(io.Instruction(31),io.Instruction(19,12),io.Instruction(20),io.Instruction(30,21),0.U)) << 12.U).asSInt+ io.PC)
    }
    //AUIPC    
    .elsewhen(io.opcode === 23.U){
        io.out := (io.Instruction(31,12).asSInt + io.PC)
    }  
    //S type
    .elsewhen(io.opcode === 35.U) {

       io.out := Cat(io.Instruction(31,25),io.Instruction(11,7)).asSInt
    }       
    .otherwise{
         io.out := 0.S
    }                                                              }
