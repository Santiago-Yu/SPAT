class n4518934 {
	public static boolean decodeFileToFile(String a6wbInjv, String VEdPKeYP) {
		boolean ylhbfrib = false;
		java.io.InputStream dXmh3BmZ = null;
		java.io.OutputStream fa9U17e6 = null;
		try {
			dXmh3BmZ = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(a6wbInjv)),
					Base64.DECODE);
			fa9U17e6 = new java.io.BufferedOutputStream(new java.io.FileOutputStream(VEdPKeYP));
			byte[] lGaBO37P = new byte[65536];
			int yP6DWbly = -1;
			while ((yP6DWbly = dXmh3BmZ.read(lGaBO37P)) >= 0) {
				fa9U17e6.write(lGaBO37P, 0, yP6DWbly);
			}
			ylhbfrib = true;
		} catch (java.io.IOException s3ZnTshy) {
			s3ZnTshy.printStackTrace();
		} finally {
			try {
				dXmh3BmZ.close();
			} catch (Exception Mg6JZFVN) {
			}
			try {
				fa9U17e6.close();
			} catch (Exception cOy5IWGS) {
			}
		}
		return ylhbfrib;
	}

}