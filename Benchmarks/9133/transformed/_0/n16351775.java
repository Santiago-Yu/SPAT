class n16351775 {
	public static boolean encodeFileToFile(String hf0ZW2fk, String MTYkprXF) {
		boolean o2tqGMqj = false;
		java.io.InputStream sndHzwTV = null;
		java.io.OutputStream yQSlyCaI = null;
		try {
			sndHzwTV = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(hf0ZW2fk)),
					Base64.ENCODE);
			yQSlyCaI = new java.io.BufferedOutputStream(new java.io.FileOutputStream(MTYkprXF));
			byte[] vCMp4WRe = new byte[65536];
			int qA2wfqQH = -1;
			while ((qA2wfqQH = sndHzwTV.read(vCMp4WRe)) >= 0) {
				yQSlyCaI.write(vCMp4WRe, 0, qA2wfqQH);
			}
			o2tqGMqj = true;
		} catch (java.io.IOException hHQgVDNy) {
			hHQgVDNy.printStackTrace();
		} finally {
			try {
				sndHzwTV.close();
			} catch (Exception rLs5BmG2) {
			}
			try {
				yQSlyCaI.close();
			} catch (Exception l3BQOYd9) {
			}
		}
		return o2tqGMqj;
	}

}