package com.programdaily.virt.instructions;

import com.programdaily.virt.ExitCode;
import com.programdaily.virt.Memory;
import com.programdaily.virt.Registers;

public class Jump extends Instruction {

	public Jump() {
		super(6);
	}
	
	@Override
	public ExitCode execute(Memory mem, Registers registers) {
		short jump = fetchVariable(mem, registers);
		registers.setProgramCounter(jump);
		return ExitCode.CONTINUE;
	}

}
