class n8625347 {
	public static boolean decodeFileToFile(String HMxfIeXT, String UvwTJn6c) {
		boolean vCERcbYv = false;
		java.io.InputStream pWCRSpMX = null;
		java.io.OutputStream DPfYZ4ww = null;
		try {
			pWCRSpMX = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(HMxfIeXT)),
					Base64.DECODE);
			DPfYZ4ww = new java.io.BufferedOutputStream(new java.io.FileOutputStream(UvwTJn6c));
			byte[] DbY8ibQG = new byte[65536];
			int i3Bi9Wsq = -1;
			while ((i3Bi9Wsq = pWCRSpMX.read(DbY8ibQG)) >= 0) {
				DPfYZ4ww.write(DbY8ibQG, 0, i3Bi9Wsq);
			}
			vCERcbYv = true;
		} catch (java.io.IOException tv63O6bS) {
			tv63O6bS.printStackTrace();
		} finally {
			try {
				pWCRSpMX.close();
			} catch (Exception W8D5IK6m) {
			}
			try {
				DPfYZ4ww.close();
			} catch (Exception W7A7b7x2) {
			}
		}
		return vCERcbYv;
	}

}