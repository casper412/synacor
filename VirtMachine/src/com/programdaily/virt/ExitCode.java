package com.programdaily.virt;

public enum ExitCode {
	CONTINUE(-1),
	SUCCESS(0),
	FAULT(1);
	
	 private final int value;
	 
	 ExitCode(final int newValue) {
		 value = newValue;
	 }
	 
	 public int getValue() { return value; }
}
