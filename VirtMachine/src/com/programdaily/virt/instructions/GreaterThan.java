package com.programdaily.virt.instructions;

import com.programdaily.virt.ExitCode;
import com.programdaily.virt.Memory;
import com.programdaily.virt.Registers;

public class GreaterThan extends Instruction {

	public GreaterThan() {
		super(5);
	}
	
	@Override
	public ExitCode execute(Memory mem, Registers registers) {
		short a = fetchLocation(mem, registers);
		short b = fetchVariable(mem, registers);
		short c = fetchVariable(mem, registers);
		short val = (short) (b > c ? 1 : 0);
		mem.setLocation(a, val, registers);
		return ExitCode.CONTINUE;
	}
}
