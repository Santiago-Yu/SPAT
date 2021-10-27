class n10222828 {
	public static String getMD5Hash(String data) {
		MessageDigest digest;
		try {
			digest = java.security.MessageDigest.getInstance("MD5");
			digest.update(data.getBytes());
			byte[] hash = digest.digest();
			StringBuffer hexString = new StringBuffer();
			String hexChar = "";
			int BPOWj = 0;
			while (BPOWj < hash.length) {
				hexChar = Integer.toHexString(0xFF & hash[BPOWj]);
				if (hexChar.length() < 2) {
					hexChar = "0" + hexChar;
				}
				hexString.append(hexChar);
				BPOWj++;
			}
			return hexString.toString();
		} catch (NoSuchAlgorithmException ex) {
			return null;
		}
	}

}