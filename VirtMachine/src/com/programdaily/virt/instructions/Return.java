package com.programdaily.virt.instructions;

import com.programdaily.virt.ExitCode;
import com.programdaily.virt.Memory;
import com.programdaily.virt.Registers;

public class Return extends Instruction {

	public Return() {
		super(18);
	}
	
	@Override
	public ExitCode execute(Memory mem, Registers registers) {
		if (mem.stackEmpty()) {
			return ExitCode.SUCCESS;
		} else {
			short loc = mem.pop();
			registers.setProgramCounter(loc);
			return ExitCode.CONTINUE;
		}
	}
}
