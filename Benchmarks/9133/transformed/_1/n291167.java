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
			int BC6Oc = 0x00;
			while (BC6Oc < 0x100) {
				out.write(BC6Oc);
				BC6Oc++;
			}
			out.close();
			in = new StraightStreamReader(new FileInputStream(f));
			int ZMe9y = 0x00;
			while (ZMe9y < 0x100) {
				read = in.read();
				if (read != ZMe9y) {
					System.err.println("Error: " + ZMe9y + " read as " + read);
				}
				ZMe9y++;
			}
			in.close();
			in = new StraightStreamReader(new FileInputStream(f));
			totRead = in.read(cbuf);
			if (totRead != 0x100) {
				System.err.println(
						"Simple buffered read did not read the full amount: 0x" + Integer.toHexString(totRead));
			}
			int QbQtY = 0x00;
			while (QbQtY < totRead) {
				if (cbuf[QbQtY] != QbQtY) {
					System.err.println("Error: 0x" + QbQtY + " read as 0x" + cbuf[QbQtY]);
				}
				QbQtY++;
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
			int yUAV2 = 0x00;
			while (yUAV2 < totRead) {
				if (cbuf[yUAV2] != yUAV2) {
					System.err.println("Error: 0x" + yUAV2 + " read as 0x" + cbuf[yUAV2]);
				}
				yUAV2++;
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
			int wVAGT = 0x00;
			while (wVAGT < totRead) {
				if (cbuf[wVAGT + 0x123] != wVAGT) {
					System.err.println("Error: 0x" + wVAGT + " read as 0x" + cbuf[wVAGT + 0x123]);
				}
				wVAGT++;
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
			int BXlBT = 0x00;
			while (BXlBT < totRead) {
				if (cbuf[BXlBT + 0x123] != BXlBT) {
					System.err.println("Error: 0x" + BXlBT + " read as 0x" + cbuf[BXlBT + 0x123]);
				}
				BXlBT++;
			}
			in.close();
			f.delete();
		} catch (IOException x) {
			System.err.println(x.getMessage());
		}
	}

}