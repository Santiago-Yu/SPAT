class n18731110 {
	public static boolean decodeFileToFile(String HRte8SwA, String nRt2BwS0) {
		boolean YJTstVfC = false;
		java.io.InputStream tEC7Zs5f = null;
		java.io.OutputStream zNvkJEEX = null;
		try {
			tEC7Zs5f = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(HRte8SwA)),
					Base64.DECODE);
			zNvkJEEX = new java.io.BufferedOutputStream(new java.io.FileOutputStream(nRt2BwS0));
			byte[] T23z7jv8 = new byte[65536];
			int JfIjqID5 = -1;
			while ((JfIjqID5 = tEC7Zs5f.read(T23z7jv8)) >= 0) {
				zNvkJEEX.write(T23z7jv8, 0, JfIjqID5);
			}
			YJTstVfC = true;
		} catch (java.io.IOException qJHrc34D) {
			qJHrc34D.printStackTrace();
		} finally {
			try {
				tEC7Zs5f.close();
			} catch (Exception NAppPcqp) {
			}
			try {
				zNvkJEEX.close();
			} catch (Exception QaoldcrC) {
			}
		}
		return YJTstVfC;
	}

}