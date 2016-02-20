package com.programdaily.virt.instructions;

import com.programdaily.virt.ExitCode;
import com.programdaily.virt.Memory;
import com.programdaily.virt.Registers;

public class Set extends Instruction {

	public Set() {
		super(1);
	}
	
	@Override
	public ExitCode execute(Memory mem, Registers registers) {
		short aLoc = fetchLocation(mem, registers);
		short b = fetchVariable(mem, registers);
		mem.setLocation(aLoc, b, registers);
		return ExitCode.CONTINUE;
	}
}
