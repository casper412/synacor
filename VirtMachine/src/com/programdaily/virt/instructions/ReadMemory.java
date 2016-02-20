package com.programdaily.virt.instructions;

import com.programdaily.virt.ExitCode;
import com.programdaily.virt.Memory;
import com.programdaily.virt.Registers;

public class ReadMemory extends Instruction {

	public ReadMemory() {
		super(15);
	}
	
	@Override
	public ExitCode execute(Memory mem, Registers registers) {
		short aLoc = fetchLocation(mem, registers);
		short bLoc = fetchVariable(mem, registers);
		short b = mem.getLocation(bLoc, registers);
		mem.setLocation(aLoc, b, registers);
		return ExitCode.CONTINUE;
	}
}
