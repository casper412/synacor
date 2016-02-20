package com.programdaily.virt.instructions;

import com.programdaily.virt.ExitCode;
import com.programdaily.virt.Memory;
import com.programdaily.virt.Registers;

public class Call extends Instruction {

	public Call() {
		super(17);
	}
	
	@Override
	public ExitCode execute(Memory mem, Registers registers) {
		short jump = fetchVariable(mem, registers);
		short ret = registers.getProgramCounter();
		mem.push(ret);
		registers.setProgramCounter(jump);
		return ExitCode.CONTINUE;
	}
}
