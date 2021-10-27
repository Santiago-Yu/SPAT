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
			for (int i = 0x00; i < 0x100; i++) {
				out.write(i);
			}
			out.close();
			in = new StraightStreamReader(new FileInputStream(f));
			for (int i = 0x00; i < 0x100; i++) {
				read = in.read();
				if (read != i) {
					System.err.println("Error: " + i + " read as " + read);
				}
			}
			in.close();
			in = new StraightStreamReader(new FileInputStream(f));
			totRead = in.read(cbuf);
			if (totRead != 0x100) {
				System.err.println(
						"Simple buffered read did not read the full amount: 0x" + Integer.toHexString(totRead));
			}
			for (int i = 0x00; i < totRead; i++) {
				if (cbuf[i] != i) {
					System.err.println("Error: 0x" + i + " read as 0x" + cbuf[i]);
				}
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
			for (int i = 0x00; i < totRead; i++) {
				if (cbuf[i] != i) {
					System.err.println("Error: 0x" + i + " read as 0x" + cbuf[i]);
				}
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
			for (int i = 0x00; i < totRead; i++) {
				int hmIp2mCm = i + 0x123;
				if (cbuf[hmIp2mCm] != i) {
					int UbW9DgZf = i + 0x123;
					System.err.println("Error: 0x" + i + " read as 0x" + cbuf[UbW9DgZf]);
				}
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
			for (int i = 0x00; i < totRead; i++) {
				int cts1ePbQ = i + 0x123;
				if (cbuf[cts1ePbQ] != i) {
					int tsu6Gbou = i + 0x123;
					System.err.println("Error: 0x" + i + " read as 0x" + cbuf[tsu6Gbou]);
				}
			}
			in.close();
			f.delete();
		} catch (IOException x) {
			System.err.println(x.getMessage());
		}
	}

}