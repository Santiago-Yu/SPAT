class n291167 {
	private static void main(String[] XBorBbxk) {
		try {
			File MVSJo4X6 = new File("test.txt");
			if (MVSJo4X6.exists()) {
				throw new IOException(MVSJo4X6 + " already exists.  I don't want to overwrite it.");
			}
			StraightStreamReader zPmNQA3S;
			char[] SL9jcpDz = new char[0x1000];
			int SRw3WXhK;
			int TiRr3qqy;
			FileOutputStream dt8SljMz = new FileOutputStream(MVSJo4X6);
			for (int CxPqvRIe = 0x00; CxPqvRIe < 0x100; CxPqvRIe++) {
				dt8SljMz.write(CxPqvRIe);
			}
			dt8SljMz.close();
			zPmNQA3S = new StraightStreamReader(new FileInputStream(MVSJo4X6));
			for (int lQ21IkPd = 0x00; lQ21IkPd < 0x100; lQ21IkPd++) {
				SRw3WXhK = zPmNQA3S.read();
				if (SRw3WXhK != lQ21IkPd) {
					System.err.println("Error: " + lQ21IkPd + " read as " + SRw3WXhK);
				}
			}
			zPmNQA3S.close();
			zPmNQA3S = new StraightStreamReader(new FileInputStream(MVSJo4X6));
			TiRr3qqy = zPmNQA3S.read(SL9jcpDz);
			if (TiRr3qqy != 0x100) {
				System.err.println(
						"Simple buffered read did not read the full amount: 0x" + Integer.toHexString(TiRr3qqy));
			}
			for (int hzvHXe80 = 0x00; hzvHXe80 < TiRr3qqy; hzvHXe80++) {
				if (SL9jcpDz[hzvHXe80] != hzvHXe80) {
					System.err.println("Error: 0x" + hzvHXe80 + " read as 0x" + SL9jcpDz[hzvHXe80]);
				}
			}
			zPmNQA3S.close();
			zPmNQA3S = new StraightStreamReader(new FileInputStream(MVSJo4X6));
			TiRr3qqy = 0;
			while (TiRr3qqy <= 0x100 && (SRw3WXhK = zPmNQA3S.read(SL9jcpDz, TiRr3qqy, 0x100 - TiRr3qqy)) > 0) {
				TiRr3qqy += SRw3WXhK;
			}
			if (TiRr3qqy != 0x100) {
				System.err.println("Not enough read. Bytes read: " + Integer.toHexString(TiRr3qqy));
			}
			for (int NEYKFc2g = 0x00; NEYKFc2g < TiRr3qqy; NEYKFc2g++) {
				if (SL9jcpDz[NEYKFc2g] != NEYKFc2g) {
					System.err.println("Error: 0x" + NEYKFc2g + " read as 0x" + SL9jcpDz[NEYKFc2g]);
				}
			}
			zPmNQA3S.close();
			zPmNQA3S = new StraightStreamReader(new FileInputStream(MVSJo4X6));
			TiRr3qqy = 0;
			while (TiRr3qqy <= 0x100 && (SRw3WXhK = zPmNQA3S.read(SL9jcpDz, TiRr3qqy + 0x123, 0x100 - TiRr3qqy)) > 0) {
				TiRr3qqy += SRw3WXhK;
			}
			if (TiRr3qqy != 0x100) {
				System.err.println("Not enough read. Bytes read: " + Integer.toHexString(TiRr3qqy));
			}
			for (int swJn663V = 0x00; swJn663V < TiRr3qqy; swJn663V++) {
				if (SL9jcpDz[swJn663V + 0x123] != swJn663V) {
					System.err.println("Error: 0x" + swJn663V + " read as 0x" + SL9jcpDz[swJn663V + 0x123]);
				}
			}
			zPmNQA3S.close();
			zPmNQA3S = new StraightStreamReader(new FileInputStream(MVSJo4X6));
			TiRr3qqy = 0;
			while (TiRr3qqy <= 0x100 && (SRw3WXhK = zPmNQA3S.read(SL9jcpDz, TiRr3qqy + 0x123, 7)) > 0) {
				TiRr3qqy += SRw3WXhK;
			}
			if (TiRr3qqy != 0x100) {
				System.err.println("Not enough read. Bytes read: " + Integer.toHexString(TiRr3qqy));
			}
			for (int jrHUmxRg = 0x00; jrHUmxRg < TiRr3qqy; jrHUmxRg++) {
				if (SL9jcpDz[jrHUmxRg + 0x123] != jrHUmxRg) {
					System.err.println("Error: 0x" + jrHUmxRg + " read as 0x" + SL9jcpDz[jrHUmxRg + 0x123]);
				}
			}
			zPmNQA3S.close();
			MVSJo4X6.delete();
		} catch (IOException heBjOG2X) {
			System.err.println(heBjOG2X.getMessage());
		}
	}

}