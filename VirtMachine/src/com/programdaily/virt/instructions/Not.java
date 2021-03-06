package com.programdaily.virt.instructions;

import com.programdaily.virt.ExitCode;
import com.programdaily.virt.Memory;
import com.programdaily.virt.Registers;

public class Not extends Instruction {

	public Not() {
		super(14);
	}
	
	@Override
	public ExitCode execute(Memory mem, Registers registers) {
		short a = fetchLocation(mem, registers);
		short b = fetchVariable(mem, registers);
		short val = (short) ((~b) & 0x7FFF);
		mem.setLocation(a, val, registers);
		return ExitCode.CONTINUE;
	}
}
