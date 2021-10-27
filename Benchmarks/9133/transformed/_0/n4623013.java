class n4623013 {
	public static boolean decodeFileToFile(String tvJfC3ho, String lWj7i7JO) {
		boolean GoGlTD8g = false;
		java.io.InputStream xcqHVNfM = null;
		java.io.OutputStream Vz1UUL49 = null;
		try {
			xcqHVNfM = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(tvJfC3ho)),
					Base64.DECODE);
			Vz1UUL49 = new java.io.BufferedOutputStream(new java.io.FileOutputStream(lWj7i7JO));
			byte[] sQlgGhEN = new byte[65536];
			int a3KplpIT = -1;
			while ((a3KplpIT = xcqHVNfM.read(sQlgGhEN)) >= 0) {
				Vz1UUL49.write(sQlgGhEN, 0, a3KplpIT);
			}
			GoGlTD8g = true;
		} catch (java.io.IOException sMR57KDn) {
			sMR57KDn.printStackTrace();
		} finally {
			try {
				xcqHVNfM.close();
			} catch (Exception e0OzrbpZ) {
			}
			try {
				Vz1UUL49.close();
			} catch (Exception LKmLBRHl) {
			}
		}
		return GoGlTD8g;
	}

}