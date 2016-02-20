package com.programdaily.virt;

public class Registers {
	private short NUM_REGISTERS = 8;
	private short registers[] = new short[NUM_REGISTERS];
	private short programCounter;
	
	public short getProgramCounter() {
		return programCounter;
	}

	public short advanceCounter() {
		return programCounter++;
	}

	public void setProgramCounter(short jump) {
		if (jump < 0 || jump > Memory.MAX_SIZE) {
			throw new RuntimeException("Seg Fault");
		}
		programCounter = jump;
	}

	/**
	 * Return an absolute register
	 * @param reg
	 * @return
	 */
	public short get(short reg) {
		if (reg >= 0 && reg < NUM_REGISTERS) {
			return registers[reg];
		}
		throw new RuntimeException("Unknown Register to get " + reg);
	}
	
	/**
	 * @param loc memory offest that is a register, e.g. -32768 is reg 0
	 * @param val
	 */
	public short getLocation(short loc) {
		short cloc = (short) (Machine.MAX_INT + loc);
		return get(cloc);
	}
	
	/**
	 * Return a literal value or a register
	 * @param val
	 * @return
	 */
	public short interrupt(short val) {
		if (val >= 0 && val < Machine.MAX_INT) {
			return val;
		} else {
			return getLocation(val);
		}
	}

	/**
	 * @param loc memory offest that is a register, e.g. -32768 is reg 0
	 * @param val
	 */
	public void setLocation(short loc, short val) {
		short cloc = (short) (Machine.MAX_INT + loc);
		set(cloc, val);
	}
	
	/**
	 * Used for instruction loading
	 * @param reg
	 * @param val
	 */
	public void set(short reg, short val) {
		if (reg >= 0 && reg < NUM_REGISTERS) {
			registers[reg] = val;
		} else {
			throw new RuntimeException("Unknown Register to set " + reg);
		}
	}

	public String debugString() {
		StringBuilder b = new StringBuilder();
		b.append("Registers: [");
		for (int i = 0; i < NUM_REGISTERS; i++) {
			if (i != 0) b.append(", ");
			b.append(registers[i]);
		}
		b.append("]");
		return b.toString();
	}

}
