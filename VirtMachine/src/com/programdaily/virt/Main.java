package com.programdaily.virt;

import java.io.FileNotFoundException;

public class Main {

	public static void main(String args[]) throws FileNotFoundException {
		Machine m = new Machine();
		Instructions i = new Instructions(args[0]);
		System.exit(m.run(i));
	}
}
