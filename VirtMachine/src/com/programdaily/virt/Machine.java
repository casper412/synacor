package com.programdaily.virt;

public class Machine {
	public static final int MAX_INT = 32768;
	
	Memory mem = new Memory();
	Executor executor = new Executor();
	Registers registers = new Registers();
	
	public int run(Instructions i) {
		ExitCode ret = ExitCode.CONTINUE;
		load(i);
		do {
			ret = executor.execute(mem, registers);
		} while (ret == ExitCode.CONTINUE);
		System.out.println("Exiting " + ret);
		return ret.getValue();
	}
	
	public void load(Instructions i) {
		short val;
		short loc = 0;
		while (i.hasMore()) {
			val = i.next();
			mem.set(loc, val);
			loc++;
		}
	}

}
