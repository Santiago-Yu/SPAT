class n10287987 {
	public static boolean decodeFileToFile(String pX1xhK5Y, String EceU40Bf) {
		boolean KlGA7MeJ = false;
		java.io.InputStream Rr4MJ7IX = null;
		java.io.OutputStream E8Snxn4w = null;
		try {
			Rr4MJ7IX = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(pX1xhK5Y)),
					Base64.DECODE);
			E8Snxn4w = new java.io.BufferedOutputStream(new java.io.FileOutputStream(EceU40Bf));
			byte[] PeXz7Y56 = new byte[65536];
			int MbX8kw3C = -1;
			while ((MbX8kw3C = Rr4MJ7IX.read(PeXz7Y56)) >= 0) {
				E8Snxn4w.write(PeXz7Y56, 0, MbX8kw3C);
			}
			KlGA7MeJ = true;
		} catch (java.io.IOException fTLOap9z) {
			fTLOap9z.printStackTrace();
		} finally {
			try {
				Rr4MJ7IX.close();
			} catch (Exception nyKPpCEo) {
			}
			try {
				E8Snxn4w.close();
			} catch (Exception guFUNPP3) {
			}
		}
		return KlGA7MeJ;
	}

}