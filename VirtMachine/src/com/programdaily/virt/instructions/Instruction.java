package com.programdaily.virt.instructions;

import com.programdaily.virt.ExitCode;
import com.programdaily.virt.Memory;
import com.programdaily.virt.Registers;

public abstract class Instruction {

	/* halt: 0
	  stop execution and terminate the program
	set: 1 a b
	  set register <a> to the value of <b>
	push: 2 a
	  push <a> onto the stack
	pop: 3 a
	  remove the top element from the stack and write it into <a>; empty stack = error
	eq: 4 a b c
	  set <a> to 1 if <b> is equal to <c>; set it to 0 otherwise
	gt: 5 a b c
	  set <a> to 1 if <b> is greater than <c>; set it to 0 otherwise
	jmp: 6 a
	  jump to <a>
	jt: 7 a b
	  if <a> is nonzero, jump to <b>
	jf: 8 a b
	  if <a> is zero, jump to <b>
	add: 9 a b c
	  assign into <a> the sum of <b> and <c> (modulo 32768)
	mult: 10 a b c
	  store into <a> the product of <b> and <c> (modulo 32768)
	mod: 11 a b c
	  store into <a> the remainder of <b> divided by <c>
	and: 12 a b c
	  stores into <a> the bitwise and of <b> and <c>
	or: 13 a b c
	  stores into <a> the bitwise or of <b> and <c>
	not: 14 a b
	  stores 15-bit bitwise inverse of <b> in <a>
	rmem: 15 a b
	  read memory at address <b> and write it to <a>
	wmem: 16 a b
	  write the value from <b> into memory at address <a>
	call: 17 a
	  write the address of the next instruction to the stack and jump to <a>
	ret: 18
	  remove the top element from the stack and jump to it; empty stack = halt
	out: 19 a
	  write the character represented by ascii code <a> to the terminal
	in: 20 a
	  read a character from the terminal and write its ascii code to <a>; it can be assumed that once input starts, it will continue until a newline is encountered; this means that you can safely read whole lines from the keyboard and trust that they will be fully read
	noop: 21
	  no operation
	 */
	
	private short code;
	
	Instruction(int code) {
		this.code = (short) code;
	}

	public short getCode() {
		return code;
	}

	public abstract ExitCode execute(Memory mem, Registers registers);
	
	/**
	 * Advance the program pointer taking a location
	 * Dereference the location
	 * @param mem
	 * @param registers
	 * @return the usable location for the target of an operation
	 */
	public short fetchLocation(Memory mem, Registers registers) {
		short locationRef = registers.advanceCounter();
		short location = mem.getLocation(locationRef, registers);
		return location;
	}
	
	/**
	 * Advance the program pointer taking a location
	 * Dereference the location
	 * and interrupt that location as a literal or a register
	 * @param mem
	 * @param registers
	 * @return the usable value for an operation
	 */
	public short fetchVariable(Memory mem, Registers registers) {
		short variableLoc = registers.advanceCounter();
		short variable = mem.getLocation(variableLoc, registers);
		variable = registers.interrupt(variable);
		return variable;
	}
}
