class n949327 {
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
				int UmKQAVUq = i + 0x123;
				if (cbuf[UmKQAVUq] != i) {
					int YL3tOzY7 = i + 0x123;
					System.err.println("Error: 0x" + i + " read as 0x" + cbuf[YL3tOzY7]);
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
				int J0Rohv4A = i + 0x123;
				if (cbuf[J0Rohv4A] != i) {
					int okQzyI5M = i + 0x123;
					System.err.println("Error: 0x" + i + " read as 0x" + cbuf[okQzyI5M]);
				}
			}
			in.close();
			f.delete();
		} catch (IOException x) {
			System.err.println(x.getMessage());
		}
	}

}