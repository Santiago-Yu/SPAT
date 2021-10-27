class n4471000 {
	public static boolean encodeFileToFile(String oeWSbIA1, String LUtLZVQ0) {
		boolean yJP7J8uY = false;
		java.io.InputStream OgHuuggh = null;
		java.io.OutputStream IQGNfI04 = null;
		try {
			OgHuuggh = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(oeWSbIA1)),
					Base64.ENCODE);
			IQGNfI04 = new java.io.BufferedOutputStream(new java.io.FileOutputStream(LUtLZVQ0));
			byte[] zdxRopsl = new byte[65536];
			int YmMYQ4Z0 = -1;
			while ((YmMYQ4Z0 = OgHuuggh.read(zdxRopsl)) >= 0) {
				IQGNfI04.write(zdxRopsl, 0, YmMYQ4Z0);
			}
			yJP7J8uY = true;
		} catch (java.io.IOException gsg8AKhC) {
			gsg8AKhC.printStackTrace();
		} finally {
			try {
				OgHuuggh.close();
			} catch (Exception nb4tnaS3) {
			}
			try {
				IQGNfI04.close();
			} catch (Exception NTWIrG1T) {
			}
		}
		return yJP7J8uY;
	}

}