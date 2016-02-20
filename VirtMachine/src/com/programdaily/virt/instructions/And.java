package com.programdaily.virt.instructions;

import com.programdaily.virt.ExitCode;
import com.programdaily.virt.Memory;
import com.programdaily.virt.Registers;

public class And extends Instruction {

	public And() {
		super(12);
	}
	
	@Override
	public ExitCode execute(Memory mem, Registers registers) {
		short a = fetchLocation(mem, registers);
		short b = fetchVariable(mem, registers);
		short c = fetchVariable(mem, registers);
		short val = (short) (b & c);
		mem.setLocation(a, val, registers);
		return ExitCode.CONTINUE;
	}
}
