class n5751314 {
	public static boolean decodeFileToFile(String PUARXPlN, String hjZqYjR3) {
		boolean f98LnR25 = false;
		java.io.InputStream bWWcS9bF = null;
		java.io.OutputStream opa9BnNZ = null;
		try {
			bWWcS9bF = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(PUARXPlN)),
					Base64.DECODE);
			opa9BnNZ = new java.io.BufferedOutputStream(new java.io.FileOutputStream(hjZqYjR3));
			byte[] ieKQpRAW = new byte[65536];
			int lUA8TgvR = -1;
			while ((lUA8TgvR = bWWcS9bF.read(ieKQpRAW)) >= 0) {
				opa9BnNZ.write(ieKQpRAW, 0, lUA8TgvR);
			}
			f98LnR25 = true;
		} catch (java.io.IOException NipMo7CN) {
			NipMo7CN.printStackTrace();
		} finally {
			closeQuietly(bWWcS9bF);
			closeQuietly(opa9BnNZ);
		}
		return f98LnR25;
	}

}