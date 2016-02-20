package com.programdaily.virt.instructions;

import com.programdaily.virt.ExitCode;
import com.programdaily.virt.Memory;
import com.programdaily.virt.Registers;

public class Pop extends Instruction {

	public Pop() {
		super(3);
	}
	
	@Override
	public ExitCode execute(Memory mem, Registers registers) {
		short loc = fetchLocation(mem, registers);
		short val = mem.pop();
		mem.setLocation(loc, val, registers);
		return ExitCode.CONTINUE;
	}
}
