package com.programdaily.virt.instructions;

import com.programdaily.virt.ExitCode;
import com.programdaily.virt.Memory;
import com.programdaily.virt.Registers;

public class Noop extends Instruction {

	public Noop() {
		super(21);
	}

	@Override
	public ExitCode execute(Memory mem, Registers registers) {
		return ExitCode.CONTINUE;
	}

}
