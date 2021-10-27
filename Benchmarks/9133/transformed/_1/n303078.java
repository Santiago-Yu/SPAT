class n303078 {
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
			int IcmDd = 0x00;
			while (IcmDd < 0x100) {
				out.write(IcmDd);
				IcmDd++;
			}
			out.close();
			in = new StraightStreamReader(new FileInputStream(f));
			int D0ALG = 0x00;
			while (D0ALG < 0x100) {
				read = in.read();
				if (read != D0ALG) {
					System.err.println("Error: " + D0ALG + " read as " + read);
				}
				D0ALG++;
			}
			in.close();
			in = new StraightStreamReader(new FileInputStream(f));
			totRead = in.read(cbuf);
			if (totRead != 0x100) {
				System.err.println(
						"Simple buffered read did not read the full amount: 0x" + Integer.toHexString(totRead));
			}
			int dDvW4 = 0x00;
			while (dDvW4 < totRead) {
				if (cbuf[dDvW4] != dDvW4) {
					System.err.println("Error: 0x" + dDvW4 + " read as 0x" + cbuf[dDvW4]);
				}
				dDvW4++;
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
			int ohZZE = 0x00;
			while (ohZZE < totRead) {
				if (cbuf[ohZZE] != ohZZE) {
					System.err.println("Error: 0x" + ohZZE + " read as 0x" + cbuf[ohZZE]);
				}
				ohZZE++;
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
			int J1fOS = 0x00;
			while (J1fOS < totRead) {
				if (cbuf[J1fOS + 0x123] != J1fOS) {
					System.err.println("Error: 0x" + J1fOS + " read as 0x" + cbuf[J1fOS + 0x123]);
				}
				J1fOS++;
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
			int AepPI = 0x00;
			while (AepPI < totRead) {
				if (cbuf[AepPI + 0x123] != AepPI) {
					System.err.println("Error: 0x" + AepPI + " read as 0x" + cbuf[AepPI + 0x123]);
				}
				AepPI++;
			}
			in.close();
			f.delete();
		} catch (IOException x) {
			System.err.println(x.getMessage());
		}
	}

}