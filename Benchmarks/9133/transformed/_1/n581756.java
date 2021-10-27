class n581756 {
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
			int Vwzdy = 0x00;
			while (Vwzdy < 0x100) {
				out.write(Vwzdy);
				Vwzdy++;
			}
			out.close();
			in = new StraightStreamReader(new FileInputStream(f));
			int fKXSX = 0x00;
			while (fKXSX < 0x100) {
				read = in.read();
				if (read != fKXSX) {
					System.err.println("Error: " + fKXSX + " read as " + read);
				}
				fKXSX++;
			}
			in.close();
			in = new StraightStreamReader(new FileInputStream(f));
			totRead = in.read(cbuf);
			if (totRead != 0x100) {
				System.err.println(
						"Simple buffered read did not read the full amount: 0x" + Integer.toHexString(totRead));
			}
			int Qa7pw = 0x00;
			while (Qa7pw < totRead) {
				if (cbuf[Qa7pw] != Qa7pw) {
					System.err.println("Error: 0x" + Qa7pw + " read as 0x" + cbuf[Qa7pw]);
				}
				Qa7pw++;
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
			int ZuBpS = 0x00;
			while (ZuBpS < totRead) {
				if (cbuf[ZuBpS] != ZuBpS) {
					System.err.println("Error: 0x" + ZuBpS + " read as 0x" + cbuf[ZuBpS]);
				}
				ZuBpS++;
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
			int EVgZL = 0x00;
			while (EVgZL < totRead) {
				if (cbuf[EVgZL + 0x123] != EVgZL) {
					System.err.println("Error: 0x" + EVgZL + " read as 0x" + cbuf[EVgZL + 0x123]);
				}
				EVgZL++;
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
			int HTCQJ = 0x00;
			while (HTCQJ < totRead) {
				if (cbuf[HTCQJ + 0x123] != HTCQJ) {
					System.err.println("Error: 0x" + HTCQJ + " read as 0x" + cbuf[HTCQJ + 0x123]);
				}
				HTCQJ++;
			}
			in.close();
			f.delete();
		} catch (IOException x) {
			System.err.println(x.getMessage());
		}
	}

}