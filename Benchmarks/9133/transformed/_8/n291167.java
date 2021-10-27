class n291167 {
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
				int slUfipmB = i + 0x123;
				if (cbuf[slUfipmB] != i) {
					int LYV7mx8g = i + 0x123;
					System.err.println("Error: 0x" + i + " read as 0x" + cbuf[LYV7mx8g]);
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
				int mm7RElwq = i + 0x123;
				if (cbuf[mm7RElwq] != i) {
					int pOGgjero = i + 0x123;
					System.err.println("Error: 0x" + i + " read as 0x" + cbuf[pOGgjero]);
				}
			}
			in.close();
			f.delete();
		} catch (IOException x) {
			System.err.println(x.getMessage());
		}
	}

}