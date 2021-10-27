class n7225732 {
	private static void main(String[] BI9QPQgi) {
		try {
			File dNywp0wQ = new File("test.txt");
			if (dNywp0wQ.exists()) {
				throw new IOException(dNywp0wQ + " already exists.  I don't want to overwrite it.");
			}
			StraightStreamReader KaqEZPPS;
			char[] OqEhaRzb = new char[0x1000];
			int oS7jxTli;
			int mS8zvu39;
			FileOutputStream cm2FzH1U = new FileOutputStream(dNywp0wQ);
			for (int cy0nKV0p = 0x00; cy0nKV0p < 0x100; cy0nKV0p++) {
				cm2FzH1U.write(cy0nKV0p);
			}
			cm2FzH1U.close();
			KaqEZPPS = new StraightStreamReader(new FileInputStream(dNywp0wQ));
			for (int tUSEZeix = 0x00; tUSEZeix < 0x100; tUSEZeix++) {
				oS7jxTli = KaqEZPPS.read();
				if (oS7jxTli != tUSEZeix) {
					System.err.println("Error: " + tUSEZeix + " read as " + oS7jxTli);
				}
			}
			KaqEZPPS.close();
			KaqEZPPS = new StraightStreamReader(new FileInputStream(dNywp0wQ));
			mS8zvu39 = KaqEZPPS.read(OqEhaRzb);
			if (mS8zvu39 != 0x100) {
				System.err.println(
						"Simple buffered read did not read the full amount: 0x" + Integer.toHexString(mS8zvu39));
			}
			for (int JuAu4eSK = 0x00; JuAu4eSK < mS8zvu39; JuAu4eSK++) {
				if (OqEhaRzb[JuAu4eSK] != JuAu4eSK) {
					System.err.println("Error: 0x" + JuAu4eSK + " read as 0x" + OqEhaRzb[JuAu4eSK]);
				}
			}
			KaqEZPPS.close();
			KaqEZPPS = new StraightStreamReader(new FileInputStream(dNywp0wQ));
			mS8zvu39 = 0;
			while (mS8zvu39 <= 0x100 && (oS7jxTli = KaqEZPPS.read(OqEhaRzb, mS8zvu39, 0x100 - mS8zvu39)) > 0) {
				mS8zvu39 += oS7jxTli;
			}
			if (mS8zvu39 != 0x100) {
				System.err.println("Not enough read. Bytes read: " + Integer.toHexString(mS8zvu39));
			}
			for (int QsNJjSyD = 0x00; QsNJjSyD < mS8zvu39; QsNJjSyD++) {
				if (OqEhaRzb[QsNJjSyD] != QsNJjSyD) {
					System.err.println("Error: 0x" + QsNJjSyD + " read as 0x" + OqEhaRzb[QsNJjSyD]);
				}
			}
			KaqEZPPS.close();
			KaqEZPPS = new StraightStreamReader(new FileInputStream(dNywp0wQ));
			mS8zvu39 = 0;
			while (mS8zvu39 <= 0x100 && (oS7jxTli = KaqEZPPS.read(OqEhaRzb, mS8zvu39 + 0x123, 0x100 - mS8zvu39)) > 0) {
				mS8zvu39 += oS7jxTli;
			}
			if (mS8zvu39 != 0x100) {
				System.err.println("Not enough read. Bytes read: " + Integer.toHexString(mS8zvu39));
			}
			for (int xTjlDD7K = 0x00; xTjlDD7K < mS8zvu39; xTjlDD7K++) {
				if (OqEhaRzb[xTjlDD7K + 0x123] != xTjlDD7K) {
					System.err.println("Error: 0x" + xTjlDD7K + " read as 0x" + OqEhaRzb[xTjlDD7K + 0x123]);
				}
			}
			KaqEZPPS.close();
			KaqEZPPS = new StraightStreamReader(new FileInputStream(dNywp0wQ));
			mS8zvu39 = 0;
			while (mS8zvu39 <= 0x100 && (oS7jxTli = KaqEZPPS.read(OqEhaRzb, mS8zvu39 + 0x123, 7)) > 0) {
				mS8zvu39 += oS7jxTli;
			}
			if (mS8zvu39 != 0x100) {
				System.err.println("Not enough read. Bytes read: " + Integer.toHexString(mS8zvu39));
			}
			for (int Ea9tqcj3 = 0x00; Ea9tqcj3 < mS8zvu39; Ea9tqcj3++) {
				if (OqEhaRzb[Ea9tqcj3 + 0x123] != Ea9tqcj3) {
					System.err.println("Error: 0x" + Ea9tqcj3 + " read as 0x" + OqEhaRzb[Ea9tqcj3 + 0x123]);
				}
			}
			KaqEZPPS.close();
			dNywp0wQ.delete();
		} catch (IOException q442bbQt) {
			System.err.println(q442bbQt.getMessage());
		}
	}

}