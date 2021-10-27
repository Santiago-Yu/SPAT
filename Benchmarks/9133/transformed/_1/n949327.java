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
			int GNZoX = 0x00;
			while (GNZoX < 0x100) {
				out.write(GNZoX);
				GNZoX++;
			}
			out.close();
			in = new StraightStreamReader(new FileInputStream(f));
			int mIE0a = 0x00;
			while (mIE0a < 0x100) {
				read = in.read();
				if (read != mIE0a) {
					System.err.println("Error: " + mIE0a + " read as " + read);
				}
				mIE0a++;
			}
			in.close();
			in = new StraightStreamReader(new FileInputStream(f));
			totRead = in.read(cbuf);
			if (totRead != 0x100) {
				System.err.println(
						"Simple buffered read did not read the full amount: 0x" + Integer.toHexString(totRead));
			}
			int ilxk3 = 0x00;
			while (ilxk3 < totRead) {
				if (cbuf[ilxk3] != ilxk3) {
					System.err.println("Error: 0x" + ilxk3 + " read as 0x" + cbuf[ilxk3]);
				}
				ilxk3++;
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
			int zEGEp = 0x00;
			while (zEGEp < totRead) {
				if (cbuf[zEGEp] != zEGEp) {
					System.err.println("Error: 0x" + zEGEp + " read as 0x" + cbuf[zEGEp]);
				}
				zEGEp++;
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
			int jYxmP = 0x00;
			while (jYxmP < totRead) {
				if (cbuf[jYxmP + 0x123] != jYxmP) {
					System.err.println("Error: 0x" + jYxmP + " read as 0x" + cbuf[jYxmP + 0x123]);
				}
				jYxmP++;
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
			int ofBYU = 0x00;
			while (ofBYU < totRead) {
				if (cbuf[ofBYU + 0x123] != ofBYU) {
					System.err.println("Error: 0x" + ofBYU + " read as 0x" + cbuf[ofBYU + 0x123]);
				}
				ofBYU++;
			}
			in.close();
			f.delete();
		} catch (IOException x) {
			System.err.println(x.getMessage());
		}
	}

}