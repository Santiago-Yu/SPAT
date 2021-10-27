class n14183084 {
	public static boolean decodeFileToFile(String EeGLPyRK, String BG4AeWAg) {
		boolean stCLktSz = false;
		java.io.InputStream e9Xr2nUT = null;
		java.io.OutputStream Kxo3WwSp = null;
		try {
			e9Xr2nUT = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(EeGLPyRK)),
					Base64.DECODE);
			Kxo3WwSp = new java.io.BufferedOutputStream(new java.io.FileOutputStream(BG4AeWAg));
			byte[] AkfYM4Mr = new byte[65536];
			int RKb2F1za = -1;
			while ((RKb2F1za = e9Xr2nUT.read(AkfYM4Mr)) >= 0) {
				Kxo3WwSp.write(AkfYM4Mr, 0, RKb2F1za);
			}
			stCLktSz = true;
		} catch (java.io.IOException ehaGFvW7) {
			ehaGFvW7.printStackTrace();
		} finally {
			try {
				e9Xr2nUT.close();
			} catch (Exception vNk1wCjG) {
			}
			try {
				Kxo3WwSp.close();
			} catch (Exception H1Ziqpxl) {
			}
		}
		return stCLktSz;
	}

}