package com.programdaily.virt;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Instructions {
	
	private FileInputStream input;
	
	public Instructions(String file) throws FileNotFoundException {
		input = new FileInputStream(file);
	}

	public boolean hasMore() {
		try {
			return input.available() != 0;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public short next() {
		short val = 0;
		byte b[] = new byte[2];
		try {
			input.read(b, 0, 2);
			//Switch to big endian
			val = (short) ((b[0] & 0xFF) + ((b[1] & 0xFF) << 8));
		} catch (IOException e) {
			throw new RuntimeException("read failed", e);
		}
		return val;
	}

}
