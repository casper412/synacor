package com.programdaily.virt.instructions;

import java.io.IOException;

import com.programdaily.virt.ExitCode;
import com.programdaily.virt.Memory;
import com.programdaily.virt.Registers;

public class Read extends Instruction {

	private StringBuilder buffer = new StringBuilder();
	
	public enum Commands {
		PRINT_REGISTERS,
		FIX_TELEPORTER;
	}
	
	public Read() {
		super(20);
	}

	@Override
	public ExitCode execute(Memory mem, Registers registers) {
		short aLoc = fetchLocation(mem, registers);
		try {
			int val = System.in.read();
			char chr = (char) (val & 0xFF);
			buffer.append(chr);
		} catch (IOException e) {
			throw new RuntimeException("Failed to read from terminal");
		}
		char last = buffer.charAt(buffer.length() - 1);
		if (last == '\n') {
			String command = buffer.toString();
			System.out.println("Command: " + command);
			buffer = new StringBuilder();
			command = command.trim();
			//Check for overrides
			try {
				switch (Commands.valueOf(command)) {
					case PRINT_REGISTERS: {
						System.out.println(registers.debugString());
					} break; case FIX_TELEPORTER: {
						//https://github.com/fwenzel/synacor-challenge/blob/master/vm/vm.py
						//Dissambly is off by 22 addresses
						registers.set((short) 7, (short) 5);
						mem.set(6027, 1); mem.set(6028, -32767); mem.set(6029, -32761); //<reg2> = <reg8>
						mem.set(6030, 9); mem.set(6031, -32768); mem.set(6032, -32767); mem.set(6033, 1);  //<reg1> = <reg2> + 1
					    mem.set(6034, 18);  // return	
					}
					//mem.set(4553, 4); mem.set(4554, -32768); mem.set(4555, -32768); mem.set(4556, -32768);  //eq
					//4553:4557] = [4, 32768, 32768, 32768]
					
				}
			} catch (Exception e) {
				// No worries
			}
		}
		//Take last character read and pass through to program
		short sval = (short) last;
		mem.setLocation(aLoc, sval, registers);
		return ExitCode.CONTINUE;
	}

}
