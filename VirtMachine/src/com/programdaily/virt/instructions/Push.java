package com.programdaily.virt.instructions;

import com.programdaily.virt.ExitCode;
import com.programdaily.virt.Memory;
import com.programdaily.virt.Registers;

public class Push extends Instruction {

	public Push() {
		super(2);
	}
	
	@Override
	public ExitCode execute(Memory mem, Registers registers) {
		short val = fetchVariable(mem, registers);
		mem.push(val);
		return ExitCode.CONTINUE;
	}
}
