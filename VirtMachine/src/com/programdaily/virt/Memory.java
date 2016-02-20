package com.programdaily.virt;

public class Memory {
	/**
	 * Maximum size of fixed memory
	 */
	public static int MAX_SIZE = (int) Math.pow(2, 15);
	/**
	 * Maximum stack
	 */
	public static int MAX_STACK_SIZE = (int) Math.pow(2, 14);

	/**
	 * Unbounded stack
	 */
	private short[] stack = new short[MAX_STACK_SIZE];
	/**
	 * Static memory
	 */
	private short arr[] = new short[MAX_SIZE];
	
	/**
	 * Location of the top of the stack
	 */
	private short stackLocation = 0;
	
	public void set(short loc, short val) {
		arr[loc] = val;
	}

	public void set(int i, int j) {
		set((short)i, (short)j);
	}
	/**
	 * Return an absolute memory address
	 * @param loc
	 * @return
	 */
	public short get(short loc) {
		return arr[loc];
	}

	/**
	 * Return a memory location or register
	 * @param loc
	 * @param registers
	 * @return
	 */
	public short getLocation(short loc, Registers registers) {
		if (loc >= 0 && loc < MAX_SIZE) {
			return get(loc);
		} else {
			return registers.getLocation(loc);
		}
	}

	public void setLocation(short loc, short val, Registers registers) {
		if (loc >= 0 && loc < MAX_SIZE) {
			set(loc, val);
		} else {
			registers.setLocation(loc, val);
		}	
	}
	
	public void push(short val) {
		if (stackLocation == MAX_STACK_SIZE) {
			throw new RuntimeException("Stack overflow");
		}
		stack[stackLocation++] = val;
	}
	
	public short pop() {
		if (stackLocation == 0) {
			throw new RuntimeException("Stack underflow");
		}
		return stack[--stackLocation];
	}

	public boolean stackEmpty() {
		return stackLocation == 0;
	}
}
