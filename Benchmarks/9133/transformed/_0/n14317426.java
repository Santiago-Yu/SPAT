class n14317426 {
	public static boolean decodeFileToFile(String dCvyJIyz, String ebXc43Zr) {
		boolean KXJWdkAE = false;
		java.io.InputStream SYvXS01r = null;
		java.io.OutputStream xYO24ep6 = null;
		try {
			SYvXS01r = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(dCvyJIyz)),
					Base64.DECODE);
			xYO24ep6 = new java.io.BufferedOutputStream(new java.io.FileOutputStream(ebXc43Zr));
			byte[] Wh0cHIJL = new byte[65536];
			int oeTfT5cX = -1;
			while ((oeTfT5cX = SYvXS01r.read(Wh0cHIJL)) >= 0) {
				xYO24ep6.write(Wh0cHIJL, 0, oeTfT5cX);
			}
			KXJWdkAE = true;
		} catch (java.io.IOException xuajKDBH) {
			xuajKDBH.printStackTrace();
		} finally {
			try {
				SYvXS01r.close();
			} catch (Exception d6b7n6PH) {
			}
			try {
				xYO24ep6.close();
			} catch (Exception fGue6cPs) {
			}
		}
		return KXJWdkAE;
	}

}