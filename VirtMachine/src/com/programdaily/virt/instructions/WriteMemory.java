package com.programdaily.virt.instructions;

import com.programdaily.virt.ExitCode;
import com.programdaily.virt.Memory;
import com.programdaily.virt.Registers;

public class WriteMemory extends Instruction {

	public WriteMemory() {
		super(16);
	}
	
	@Override
	public ExitCode execute(Memory mem, Registers registers) {
		short aLoc = fetchVariable(mem, registers);
		short b = fetchVariable(mem, registers);
		mem.setLocation(aLoc, b, registers);
		return ExitCode.CONTINUE;
	}
}
