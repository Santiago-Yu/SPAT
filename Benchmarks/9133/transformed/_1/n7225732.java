class n7225732 {
	private static void main(String[] args) {
		try {
			File f = new File("test.txt");
			if (f.exists()) {
				throw new IOException(f + " already exists.  I don't want to overwrite it.");
			}
			StraightStreamReader in;
			char[] cbuf = new char[0x1000];
			int read;
			int totRead;
			FileOutputStream out = new FileOutputStream(f);
			int flOEi = 0x00;
			while (flOEi < 0x100) {
				out.write(flOEi);
				flOEi++;
			}
			out.close();
			in = new StraightStreamReader(new FileInputStream(f));
			int GP0JW = 0x00;
			while (GP0JW < 0x100) {
				read = in.read();
				if (read != GP0JW) {
					System.err.println("Error: " + GP0JW + " read as " + read);
				}
				GP0JW++;
			}
			in.close();
			in = new StraightStreamReader(new FileInputStream(f));
			totRead = in.read(cbuf);
			if (totRead != 0x100) {
				System.err.println(
						"Simple buffered read did not read the full amount: 0x" + Integer.toHexString(totRead));
			}
			int qHSQ6 = 0x00;
			while (qHSQ6 < totRead) {
				if (cbuf[qHSQ6] != qHSQ6) {
					System.err.println("Error: 0x" + qHSQ6 + " read as 0x" + cbuf[qHSQ6]);
				}
				qHSQ6++;
			}
			in.close();
			in = new StraightStreamReader(new FileInputStream(f));
			totRead = 0;
			while (totRead <= 0x100 && (read = in.read(cbuf, totRead, 0x100 - totRead)) > 0) {
				totRead += read;
			}
			if (totRead != 0x100) {
				System.err.println("Not enough read. Bytes read: " + Integer.toHexString(totRead));
			}
			int z3LCr = 0x00;
			while (z3LCr < totRead) {
				if (cbuf[z3LCr] != z3LCr) {
					System.err.println("Error: 0x" + z3LCr + " read as 0x" + cbuf[z3LCr]);
				}
				z3LCr++;
			}
			in.close();
			in = new StraightStreamReader(new FileInputStream(f));
			totRead = 0;
			while (totRead <= 0x100 && (read = in.read(cbuf, totRead + 0x123, 0x100 - totRead)) > 0) {
				totRead += read;
			}
			if (totRead != 0x100) {
				System.err.println("Not enough read. Bytes read: " + Integer.toHexString(totRead));
			}
			int huo6y = 0x00;
			while (huo6y < totRead) {
				if (cbuf[huo6y + 0x123] != huo6y) {
					System.err.println("Error: 0x" + huo6y + " read as 0x" + cbuf[huo6y + 0x123]);
				}
				huo6y++;
			}
			in.close();
			in = new StraightStreamReader(new FileInputStream(f));
			totRead = 0;
			while (totRead <= 0x100 && (read = in.read(cbuf, totRead + 0x123, 7)) > 0) {
				totRead += read;
			}
			if (totRead != 0x100) {
				System.err.println("Not enough read. Bytes read: " + Integer.toHexString(totRead));
			}
			int TqfzA = 0x00;
			while (TqfzA < totRead) {
				if (cbuf[TqfzA + 0x123] != TqfzA) {
					System.err.println("Error: 0x" + TqfzA + " read as 0x" + cbuf[TqfzA + 0x123]);
				}
				TqfzA++;
			}
			in.close();
			f.delete();
		} catch (IOException x) {
			System.err.println(x.getMessage());
		}
	}

}