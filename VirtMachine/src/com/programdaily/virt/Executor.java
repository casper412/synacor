package com.programdaily.virt;

import com.programdaily.virt.instructions.*;

public class Executor {
	private static int MAX_INSTRUCTIONS = 22;
	public Instruction instructions[] = new Instruction[MAX_INSTRUCTIONS];
	
	Executor() {
		put(new Halt());
		//Sets
		put(new Set());
		//Stack
		put(new Push());
		put(new Pop());
		//Comparisons
		put(new Equal());
		put(new GreaterThan());
		//Jumps
		put(new Jump());
		put(new JumpTrue());
		put(new JumpFalse());
		//Math
		put(new Add());
		put(new Multiply());
		put(new Modulus());
		put(new And());
		put(new Or());
		put(new Not());
		//Memory access
		put(new ReadMemory());
		put(new WriteMemory());
		//Functions
		put(new Call());
		put(new Return());
		//Input
		put(new Print());
		put(new Read());
		//Other
		put(new Noop());
	}
	
	private void put(Instruction i) {
		if (instructions[i.getCode()] != null) {
			throw new RuntimeException("Jump table collision");
		}
		instructions[i.getCode()] = i;
	}
	
	public ExitCode execute(Memory mem, Registers registers) {
		short program_counter = registers.advanceCounter();
		short ins = mem.get(program_counter);
		return perform(ins, mem, registers);
	}

	private ExitCode perform(short ins, Memory mem, Registers registers) {
		if (ins < 0 || ins >= MAX_INSTRUCTIONS) {
			throw new RuntimeException("Unrecognized instruction");
		}
		Instruction i = instructions[ins];
		if (i != null) {
			return i.execute(mem, registers);
		}
		System.err.println("Unknown instruction " + ins);
		return ExitCode.FAULT;
	}

}
