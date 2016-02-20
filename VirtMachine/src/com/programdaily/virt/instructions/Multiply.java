package com.programdaily.virt.instructions;

import com.programdaily.virt.ExitCode;
import com.programdaily.virt.Machine;
import com.programdaily.virt.Memory;
import com.programdaily.virt.Registers;

public class Multiply extends Instruction {

	public Multiply() {
		super(10);
	}
	
	@Override
	public ExitCode execute(Memory mem, Registers registers) {
		short a = fetchLocation(mem, registers);
		short b = fetchVariable(mem, registers);
		short c = fetchVariable(mem, registers);
		short val = (short) (Math.abs(b * c) % Machine.MAX_INT);
		mem.setLocation(a, val, registers);
		return ExitCode.CONTINUE;
	}
}
