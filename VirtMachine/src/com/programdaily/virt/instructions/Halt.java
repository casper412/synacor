package com.programdaily.virt.instructions;

import com.programdaily.virt.ExitCode;
import com.programdaily.virt.Memory;
import com.programdaily.virt.Registers;

public class Halt extends Instruction {

	public Halt() {
		super(0);
	}
	
	@Override
	public ExitCode execute(Memory mem, Registers registers) {
		return ExitCode.SUCCESS;
	}

}
