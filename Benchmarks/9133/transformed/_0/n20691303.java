class n20691303 {
	public static String encrypt(String ErklAOwE) {
		if (ErklAOwE == null || ErklAOwE.length() == 0) {
			throw new IllegalArgumentException("String to encript cannot be null or zero length");
		}
		StringBuffer pe7DmDlO = new StringBuffer();
		MessageDigest WHxnwnPf = null;
		try {
			WHxnwnPf = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException V4WG3rGM) {
			V4WG3rGM.printStackTrace();
		}
		WHxnwnPf.update(ErklAOwE.getBytes());
		byte[] GF6rIeI9 = WHxnwnPf.digest();
		for (int cn19c8rl = 0; cn19c8rl < GF6rIeI9.length; cn19c8rl++) {
			if ((0xff & GF6rIeI9[cn19c8rl]) < 0x10) {
				pe7DmDlO.append("0" + Integer.toHexString((0xFF & GF6rIeI9[cn19c8rl])));
			} else {
				pe7DmDlO.append(Integer.toHexString(0xFF & GF6rIeI9[cn19c8rl]));
			}
		}
		return pe7DmDlO.toString();
	}

}