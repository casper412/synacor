package com.programdaily.virt.instructions;

import com.programdaily.virt.ExitCode;
import com.programdaily.virt.Memory;
import com.programdaily.virt.Registers;

public class Print extends Instruction {

	public Print() {
		super(19);
	}

	@Override
	public ExitCode execute(Memory mem, Registers registers) {
		short chr = fetchVariable(mem, registers);
		System.out.print((char) chr);
		return ExitCode.CONTINUE;
	}

}
