class n417300 {
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
			int YYZA5 = 0x00;
			while (YYZA5 < 0x100) {
				out.write(YYZA5);
				YYZA5++;
			}
			out.close();
			in = new StraightStreamReader(new FileInputStream(f));
			int wApFq = 0x00;
			while (wApFq < 0x100) {
				read = in.read();
				if (read != wApFq) {
					System.err.println("Error: " + wApFq + " read as " + read);
				}
				wApFq++;
			}
			in.close();
			in = new StraightStreamReader(new FileInputStream(f));
			totRead = in.read(cbuf);
			if (totRead != 0x100) {
				System.err.println(
						"Simple buffered read did not read the full amount: 0x" + Integer.toHexString(totRead));
			}
			int ppoHC = 0x00;
			while (ppoHC < totRead) {
				if (cbuf[ppoHC] != ppoHC) {
					System.err.println("Error: 0x" + ppoHC + " read as 0x" + cbuf[ppoHC]);
				}
				ppoHC++;
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
			int oXxG3 = 0x00;
			while (oXxG3 < totRead) {
				if (cbuf[oXxG3] != oXxG3) {
					System.err.println("Error: 0x" + oXxG3 + " read as 0x" + cbuf[oXxG3]);
				}
				oXxG3++;
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
			int JP1Av = 0x00;
			while (JP1Av < totRead) {
				if (cbuf[JP1Av + 0x123] != JP1Av) {
					System.err.println("Error: 0x" + JP1Av + " read as 0x" + cbuf[JP1Av + 0x123]);
				}
				JP1Av++;
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
			int TpOsE = 0x00;
			while (TpOsE < totRead) {
				if (cbuf[TpOsE + 0x123] != TpOsE) {
					System.err.println("Error: 0x" + TpOsE + " read as 0x" + cbuf[TpOsE + 0x123]);
				}
				TpOsE++;
			}
			in.close();
			f.delete();
		} catch (IOException x) {
			System.err.println(x.getMessage());
		}
	}

}