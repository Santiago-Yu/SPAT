class n255765 {
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
			int UFwnE = 0x00;
			while (UFwnE < 0x100) {
				out.write(UFwnE);
				UFwnE++;
			}
			out.close();
			in = new StraightStreamReader(new FileInputStream(f));
			int NBeuf = 0x00;
			while (NBeuf < 0x100) {
				read = in.read();
				if (read != NBeuf) {
					System.err.println("Error: " + NBeuf + " read as " + read);
				}
				NBeuf++;
			}
			in.close();
			in = new StraightStreamReader(new FileInputStream(f));
			totRead = in.read(cbuf);
			if (totRead != 0x100) {
				System.err.println(
						"Simple buffered read did not read the full amount: 0x" + Integer.toHexString(totRead));
			}
			int p5Kub = 0x00;
			while (p5Kub < totRead) {
				if (cbuf[p5Kub] != p5Kub) {
					System.err.println("Error: 0x" + p5Kub + " read as 0x" + cbuf[p5Kub]);
				}
				p5Kub++;
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
			int dTm3b = 0x00;
			while (dTm3b < totRead) {
				if (cbuf[dTm3b] != dTm3b) {
					System.err.println("Error: 0x" + dTm3b + " read as 0x" + cbuf[dTm3b]);
				}
				dTm3b++;
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
			int hpYfv = 0x00;
			while (hpYfv < totRead) {
				if (cbuf[hpYfv + 0x123] != hpYfv) {
					System.err.println("Error: 0x" + hpYfv + " read as 0x" + cbuf[hpYfv + 0x123]);
				}
				hpYfv++;
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
			int tXczL = 0x00;
			while (tXczL < totRead) {
				if (cbuf[tXczL + 0x123] != tXczL) {
					System.err.println("Error: 0x" + tXczL + " read as 0x" + cbuf[tXczL + 0x123]);
				}
				tXczL++;
			}
			in.close();
			f.delete();
		} catch (IOException x) {
			System.err.println(x.getMessage());
		}
	}

}