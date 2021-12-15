package core
import chisel3._
import chisel3.util._
import chisel3.core
import chisel3.util.experimental.loadMemoryFromFile

class Main extends Module{
	val io = IO(new Bundle{
        val output = Output(UInt(32.W))
})
    val alu = Module(new ALU)
    val aluop = Module(new AluOp)
    // val  branch = Module(new BranchCtrl)//
    val condec = Module(new ControlDecoder)
    val conunit =Module (new ControlUnit)
    val datameme = Module (new DataMemory)//
    val immegen = Module (new ImmeGenerator)//
    val insmem = Module (new InsMemory)//
    val pc = Module (new PC)//
    val regfile = Module (new Reg32)
    val typedec = Module (new TypeDecoder)

    //jal
    when (insmem.io.r_data(6,0) === 111.U){
        pc.io.input := immegen.io.out
    }
    //branch
    .elsewhen(insmem.io.r_data(6,0) === 99.U){
        pc.io.input := immegen.io.out
    }
    //jalr
    .elsewhen(insmem.io.r_data(6,0) === 103.U){
        pc.io.input := immegen.io.out
    }
    .otherwise{
        pc.io.input := 0.U
    }
    
    insmem.io.write_address := pc.io.pc_output
    //Opcode identify
    // typedec.io.opCode := insmem.io.r_data(6,0)

    //RegisterFile
    regfile.io.imm_rs1 := insmem.io.r_data(19,15)
    regfile.io.imm_rs2 := insmem.io.r_data(24,20)
    regfile.io.rd_reg:= insmem.io.r_data(11,7)
    regfile.io.reg_write:=conunit.io.RegWrite


    //Immediate Generator
    immegen.io.Instruction:= insmem.io.r_data
    immegen.io.PC := pc.io.pc_output

    //ALUOP 
    (aluop.io.Inst).asUInt := insmem.io.r_data
    aluop.io.branch := conunit.io.Branch

    //alu
    alu.io.in_1 := Mux((conunit.io.Auipc).asBool,pc.io.pc_output,regfile.io.rs1_output)


    val esi = ((conunit.io.Immediate).asBool | (conunit.io.U_type).asBool | (conunit.io.store).asBool)
    alu.io.in_2 := Mux(esi,(immegen.io.out)asUInt,regfile.io.rs2_output)
    alu.io.select := Mux(((conunit.io.store).asBool|(conunit.io.Load).asBool),0.U,aluop.io.AluOut)
    regfile.io.write_data := alu.io.output

    //DataMemory

    datameme.io.addr := alu.io.output(7,0)
    datameme.io.store_data:= regfile.io.imm_rs2
    datameme.io.load := conunit.io.Load
    datameme.io.store := conunit.io.store
    regfile.io.write_data :=  datameme.io.Data_Out

}