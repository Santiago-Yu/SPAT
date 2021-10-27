class n7791429 {
	public static String hashMD5(String baseString) {
		MessageDigest digest = null;
		StringBuffer hexString = new StringBuffer();
		try {
			digest = java.security.MessageDigest.getInstance("MD5");
			digest.update(baseString.getBytes());
			byte[] hash = digest.digest();
			int bXiII = 0;
			while (bXiII < hash.length) {
				if ((0xff & hash[bXiII]) < 0x10) {
					hexString.append("0" + Integer.toHexString((0xFF & hash[bXiII])));
				} else {
					hexString.append(Integer.toHexString(0xFF & hash[bXiII]));
				}
				bXiII++;
			}
		} catch (NoSuchAlgorithmException ex) {
			Logger.getLogger(Password.class.getName()).log(Level.SEVERE, null, ex);
		}
		return hexString.toString();
	}

}