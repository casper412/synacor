package com.programdaily.virt.instructions;

import com.programdaily.virt.ExitCode;
import com.programdaily.virt.Memory;
import com.programdaily.virt.Registers;

public class JumpFalse extends Instruction {

	public JumpFalse() {
		super(8);
	}
	
	@Override
	public ExitCode execute(Memory mem, Registers registers) {
		short jumpCond = fetchVariable(mem, registers);
		short jump = fetchVariable(mem, registers);
		if (jumpCond == 0) {
			registers.setProgramCounter(jump);
		}
		return ExitCode.CONTINUE;
	}

}
