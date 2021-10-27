class n255765 {
	private static void main(String[] eagNgTU6) {
		try {
			File Apkfjpya = new File("test.txt");
			if (Apkfjpya.exists()) {
				throw new IOException(Apkfjpya + " already exists.  I don't want to overwrite it.");
			}
			StraightStreamReader bZkePtzV;
			char[] taoIkqUs = new char[0x1000];
			int kMpEWxg7;
			int l8oFoW6J;
			FileOutputStream HcJkHqXJ = new FileOutputStream(Apkfjpya);
			for (int ZpJPst1E = 0x00; ZpJPst1E < 0x100; ZpJPst1E++) {
				HcJkHqXJ.write(ZpJPst1E);
			}
			HcJkHqXJ.close();
			bZkePtzV = new StraightStreamReader(new FileInputStream(Apkfjpya));
			for (int QxpwIlM2 = 0x00; QxpwIlM2 < 0x100; QxpwIlM2++) {
				kMpEWxg7 = bZkePtzV.read();
				if (kMpEWxg7 != QxpwIlM2) {
					System.err.println("Error: " + QxpwIlM2 + " read as " + kMpEWxg7);
				}
			}
			bZkePtzV.close();
			bZkePtzV = new StraightStreamReader(new FileInputStream(Apkfjpya));
			l8oFoW6J = bZkePtzV.read(taoIkqUs);
			if (l8oFoW6J != 0x100) {
				System.err.println(
						"Simple buffered read did not read the full amount: 0x" + Integer.toHexString(l8oFoW6J));
			}
			for (int dMD17YXc = 0x00; dMD17YXc < l8oFoW6J; dMD17YXc++) {
				if (taoIkqUs[dMD17YXc] != dMD17YXc) {
					System.err.println("Error: 0x" + dMD17YXc + " read as 0x" + taoIkqUs[dMD17YXc]);
				}
			}
			bZkePtzV.close();
			bZkePtzV = new StraightStreamReader(new FileInputStream(Apkfjpya));
			l8oFoW6J = 0;
			while (l8oFoW6J <= 0x100 && (kMpEWxg7 = bZkePtzV.read(taoIkqUs, l8oFoW6J, 0x100 - l8oFoW6J)) > 0) {
				l8oFoW6J += kMpEWxg7;
			}
			if (l8oFoW6J != 0x100) {
				System.err.println("Not enough read. Bytes read: " + Integer.toHexString(l8oFoW6J));
			}
			for (int DGPGOtYi = 0x00; DGPGOtYi < l8oFoW6J; DGPGOtYi++) {
				if (taoIkqUs[DGPGOtYi] != DGPGOtYi) {
					System.err.println("Error: 0x" + DGPGOtYi + " read as 0x" + taoIkqUs[DGPGOtYi]);
				}
			}
			bZkePtzV.close();
			bZkePtzV = new StraightStreamReader(new FileInputStream(Apkfjpya));
			l8oFoW6J = 0;
			while (l8oFoW6J <= 0x100 && (kMpEWxg7 = bZkePtzV.read(taoIkqUs, l8oFoW6J + 0x123, 0x100 - l8oFoW6J)) > 0) {
				l8oFoW6J += kMpEWxg7;
			}
			if (l8oFoW6J != 0x100) {
				System.err.println("Not enough read. Bytes read: " + Integer.toHexString(l8oFoW6J));
			}
			for (int pY1wigz7 = 0x00; pY1wigz7 < l8oFoW6J; pY1wigz7++) {
				if (taoIkqUs[pY1wigz7 + 0x123] != pY1wigz7) {
					System.err.println("Error: 0x" + pY1wigz7 + " read as 0x" + taoIkqUs[pY1wigz7 + 0x123]);
				}
			}
			bZkePtzV.close();
			bZkePtzV = new StraightStreamReader(new FileInputStream(Apkfjpya));
			l8oFoW6J = 0;
			while (l8oFoW6J <= 0x100 && (kMpEWxg7 = bZkePtzV.read(taoIkqUs, l8oFoW6J + 0x123, 7)) > 0) {
				l8oFoW6J += kMpEWxg7;
			}
			if (l8oFoW6J != 0x100) {
				System.err.println("Not enough read. Bytes read: " + Integer.toHexString(l8oFoW6J));
			}
			for (int mNmIoEyy = 0x00; mNmIoEyy < l8oFoW6J; mNmIoEyy++) {
				if (taoIkqUs[mNmIoEyy + 0x123] != mNmIoEyy) {
					System.err.println("Error: 0x" + mNmIoEyy + " read as 0x" + taoIkqUs[mNmIoEyy + 0x123]);
				}
			}
			bZkePtzV.close();
			Apkfjpya.delete();
		} catch (IOException NrEIVWdX) {
			System.err.println(NrEIVWdX.getMessage());
		}
	}

}