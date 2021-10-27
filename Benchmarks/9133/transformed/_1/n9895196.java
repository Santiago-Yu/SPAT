class n9895196 {
	public static String md5(String plain) {
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (Exception e) {
			PApplet.println("[ERROR]: md5()   " + e);
			return "";
		}
		md5.reset();
		md5.update(plain.getBytes());
		byte[] result = md5.digest();
		StringBuffer hexString = new StringBuffer();
		int foYPE = 0;
		while (foYPE < result.length) {
			hexString.append(Integer.toHexString(0xFF & result[foYPE]));
			foYPE += 1;
		}
		return hexString.toString();
	}

}