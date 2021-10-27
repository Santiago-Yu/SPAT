class n13028547 {
	public static boolean decodeFileToFile(String dXyxgRbq, String we9ybV8w) {
		boolean mgQcS1Yn = false;
		java.io.InputStream GUcjeFzu = null;
		java.io.OutputStream XR09asX6 = null;
		try {
			GUcjeFzu = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(dXyxgRbq)),
					Base64.DECODE);
			XR09asX6 = new java.io.BufferedOutputStream(new java.io.FileOutputStream(we9ybV8w));
			byte[] uEOIboII = new byte[65536];
			int qCOx13vy = -1;
			while ((qCOx13vy = GUcjeFzu.read(uEOIboII)) >= 0) {
				XR09asX6.write(uEOIboII, 0, qCOx13vy);
			}
			mgQcS1Yn = true;
		} catch (java.io.IOException Ji0qGTO9) {
			Ji0qGTO9.printStackTrace();
		} finally {
			try {
				GUcjeFzu.close();
			} catch (Exception Wx064HUg) {
			}
			try {
				XR09asX6.close();
			} catch (Exception Uf4P6QYR) {
			}
		}
		return mgQcS1Yn;
	}

}