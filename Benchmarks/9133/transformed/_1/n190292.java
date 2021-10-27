class n190292 {
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
			int Pg82e = 0x00;
			while (Pg82e < 0x100) {
				out.write(Pg82e);
				Pg82e++;
			}
			out.close();
			in = new StraightStreamReader(new FileInputStream(f));
			int Yj0lR = 0x00;
			while (Yj0lR < 0x100) {
				read = in.read();
				if (read != Yj0lR) {
					System.err.println("Error: " + Yj0lR + " read as " + read);
				}
				Yj0lR++;
			}
			in.close();
			in = new StraightStreamReader(new FileInputStream(f));
			totRead = in.read(cbuf);
			if (totRead != 0x100) {
				System.err.println(
						"Simple buffered read did not read the full amount: 0x" + Integer.toHexString(totRead));
			}
			int CzCtG = 0x00;
			while (CzCtG < totRead) {
				if (cbuf[CzCtG] != CzCtG) {
					System.err.println("Error: 0x" + CzCtG + " read as 0x" + cbuf[CzCtG]);
				}
				CzCtG++;
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
			int MhpBs = 0x00;
			while (MhpBs < totRead) {
				if (cbuf[MhpBs] != MhpBs) {
					System.err.println("Error: 0x" + MhpBs + " read as 0x" + cbuf[MhpBs]);
				}
				MhpBs++;
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
			int lOh9p = 0x00;
			while (lOh9p < totRead) {
				if (cbuf[lOh9p + 0x123] != lOh9p) {
					System.err.println("Error: 0x" + lOh9p + " read as 0x" + cbuf[lOh9p + 0x123]);
				}
				lOh9p++;
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
			int wT0Ie = 0x00;
			while (wT0Ie < totRead) {
				if (cbuf[wT0Ie + 0x123] != wT0Ie) {
					System.err.println("Error: 0x" + wT0Ie + " read as 0x" + cbuf[wT0Ie + 0x123]);
				}
				wT0Ie++;
			}
			in.close();
			f.delete();
		} catch (IOException x) {
			System.err.println(x.getMessage());
		}
	}

}