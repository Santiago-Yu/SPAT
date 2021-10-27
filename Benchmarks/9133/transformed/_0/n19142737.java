class n19142737 {
	public static boolean decodeFileToFile(String bBhZQfaz, String XoW14fqb) {
		boolean imjcvOyq = false;
		java.io.InputStream RE59jJ7B = null;
		java.io.OutputStream yC8Ot7Y8 = null;
		try {
			RE59jJ7B = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(bBhZQfaz)),
					Base64.DECODE);
			yC8Ot7Y8 = new java.io.BufferedOutputStream(new java.io.FileOutputStream(XoW14fqb));
			byte[] i6p9OceJ = new byte[65536];
			int EgnyImZd = -1;
			while ((EgnyImZd = RE59jJ7B.read(i6p9OceJ)) >= 0) {
				yC8Ot7Y8.write(i6p9OceJ, 0, EgnyImZd);
			}
			imjcvOyq = true;
		} catch (java.io.IOException TAiu8Rdv) {
			TAiu8Rdv.printStackTrace();
		} finally {
			try {
				RE59jJ7B.close();
			} catch (Exception scIRSbzv) {
			}
			try {
				yC8Ot7Y8.close();
			} catch (Exception JL0tZYZK) {
			}
		}
		return imjcvOyq;
	}

}