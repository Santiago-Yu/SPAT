class n694747 {
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
			int CZPF5 = 0x00;
			while (CZPF5 < 0x100) {
				out.write(CZPF5);
				CZPF5++;
			}
			out.close();
			in = new StraightStreamReader(new FileInputStream(f));
			int Q6qhh = 0x00;
			while (Q6qhh < 0x100) {
				read = in.read();
				if (read != Q6qhh) {
					System.err.println("Error: " + Q6qhh + " read as " + read);
				}
				Q6qhh++;
			}
			in.close();
			in = new StraightStreamReader(new FileInputStream(f));
			totRead = in.read(cbuf);
			if (totRead != 0x100) {
				System.err.println(
						"Simple buffered read did not read the full amount: 0x" + Integer.toHexString(totRead));
			}
			int EZBQL = 0x00;
			while (EZBQL < totRead) {
				if (cbuf[EZBQL] != EZBQL) {
					System.err.println("Error: 0x" + EZBQL + " read as 0x" + cbuf[EZBQL]);
				}
				EZBQL++;
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
			int d9UQj = 0x00;
			while (d9UQj < totRead) {
				if (cbuf[d9UQj] != d9UQj) {
					System.err.println("Error: 0x" + d9UQj + " read as 0x" + cbuf[d9UQj]);
				}
				d9UQj++;
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
			int bLcxq = 0x00;
			while (bLcxq < totRead) {
				if (cbuf[bLcxq + 0x123] != bLcxq) {
					System.err.println("Error: 0x" + bLcxq + " read as 0x" + cbuf[bLcxq + 0x123]);
				}
				bLcxq++;
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
			int wLDfZ = 0x00;
			while (wLDfZ < totRead) {
				if (cbuf[wLDfZ + 0x123] != wLDfZ) {
					System.err.println("Error: 0x" + wLDfZ + " read as 0x" + cbuf[wLDfZ + 0x123]);
				}
				wLDfZ++;
			}
			in.close();
			f.delete();
		} catch (IOException x) {
			System.err.println(x.getMessage());
		}
	}

}