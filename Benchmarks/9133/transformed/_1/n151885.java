class n151885 {
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
			int S61EK = 0x00;
			while (S61EK < 0x100) {
				out.write(S61EK);
				S61EK++;
			}
			out.close();
			in = new StraightStreamReader(new FileInputStream(f));
			int yNlFI = 0x00;
			while (yNlFI < 0x100) {
				read = in.read();
				if (read != yNlFI) {
					System.err.println("Error: " + yNlFI + " read as " + read);
				}
				yNlFI++;
			}
			in.close();
			in = new StraightStreamReader(new FileInputStream(f));
			totRead = in.read(cbuf);
			if (totRead != 0x100) {
				System.err.println(
						"Simple buffered read did not read the full amount: 0x" + Integer.toHexString(totRead));
			}
			int CT3BR = 0x00;
			while (CT3BR < totRead) {
				if (cbuf[CT3BR] != CT3BR) {
					System.err.println("Error: 0x" + CT3BR + " read as 0x" + cbuf[CT3BR]);
				}
				CT3BR++;
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
			int IXsSK = 0x00;
			while (IXsSK < totRead) {
				if (cbuf[IXsSK] != IXsSK) {
					System.err.println("Error: 0x" + IXsSK + " read as 0x" + cbuf[IXsSK]);
				}
				IXsSK++;
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
			int OXviD = 0x00;
			while (OXviD < totRead) {
				if (cbuf[OXviD + 0x123] != OXviD) {
					System.err.println("Error: 0x" + OXviD + " read as 0x" + cbuf[OXviD + 0x123]);
				}
				OXviD++;
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
			int GszAD = 0x00;
			while (GszAD < totRead) {
				if (cbuf[GszAD + 0x123] != GszAD) {
					System.err.println("Error: 0x" + GszAD + " read as 0x" + cbuf[GszAD + 0x123]);
				}
				GszAD++;
			}
			in.close();
			f.delete();
		} catch (IOException x) {
			System.err.println(x.getMessage());
		}
	}

}