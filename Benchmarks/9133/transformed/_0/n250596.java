class n250596 {
	public static boolean decodeFileToFile(String svZahOcr, String xann8uOw) {
		boolean Q7PAhjYB = false;
		java.io.InputStream ZU6VPpVJ = null;
		java.io.OutputStream dTWuPoP9 = null;
		try {
			ZU6VPpVJ = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(svZahOcr)),
					Base64.DECODE);
			dTWuPoP9 = new java.io.BufferedOutputStream(new java.io.FileOutputStream(xann8uOw));
			byte[] CJvc4Rix = new byte[65536];
			int Y9VdMhGF = -1;
			while ((Y9VdMhGF = ZU6VPpVJ.read(CJvc4Rix)) >= 0) {
				dTWuPoP9.write(CJvc4Rix, 0, Y9VdMhGF);
			}
			Q7PAhjYB = true;
		} catch (java.io.IOException QKJllWXl) {
			QKJllWXl.printStackTrace();
		} finally {
			try {
				ZU6VPpVJ.close();
			} catch (Exception kQLmAs6O) {
			}
			try {
				dTWuPoP9.close();
			} catch (Exception cWDin5Ve) {
			}
		}
		return Q7PAhjYB;
	}

}