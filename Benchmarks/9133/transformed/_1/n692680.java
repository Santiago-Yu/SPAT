class n692680 {
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
			int LtGYw = 0x00;
			while (LtGYw < 0x100) {
				out.write(LtGYw);
				LtGYw++;
			}
			out.close();
			in = new StraightStreamReader(new FileInputStream(f));
			int cg4ya = 0x00;
			while (cg4ya < 0x100) {
				read = in.read();
				if (read != cg4ya) {
					System.err.println("Error: " + cg4ya + " read as " + read);
				}
				cg4ya++;
			}
			in.close();
			in = new StraightStreamReader(new FileInputStream(f));
			totRead = in.read(cbuf);
			if (totRead != 0x100) {
				System.err.println(
						"Simple buffered read did not read the full amount: 0x" + Integer.toHexString(totRead));
			}
			int hzMd9 = 0x00;
			while (hzMd9 < totRead) {
				if (cbuf[hzMd9] != hzMd9) {
					System.err.println("Error: 0x" + hzMd9 + " read as 0x" + cbuf[hzMd9]);
				}
				hzMd9++;
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
			int leipL = 0x00;
			while (leipL < totRead) {
				if (cbuf[leipL] != leipL) {
					System.err.println("Error: 0x" + leipL + " read as 0x" + cbuf[leipL]);
				}
				leipL++;
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
			int KysUH = 0x00;
			while (KysUH < totRead) {
				if (cbuf[KysUH + 0x123] != KysUH) {
					System.err.println("Error: 0x" + KysUH + " read as 0x" + cbuf[KysUH + 0x123]);
				}
				KysUH++;
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
			int ZW682 = 0x00;
			while (ZW682 < totRead) {
				if (cbuf[ZW682 + 0x123] != ZW682) {
					System.err.println("Error: 0x" + ZW682 + " read as 0x" + cbuf[ZW682 + 0x123]);
				}
				ZW682++;
			}
			in.close();
			f.delete();
		} catch (IOException x) {
			System.err.println(x.getMessage());
		}
	}

}