class n21857917 {
	public static String makeMD5(String pin) {
		try {
			MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
			digest.update(pin.getBytes());
			byte[] hash = digest.digest();
			StringBuffer hexString = new StringBuffer();
			int lbwNX = 0;
			while (lbwNX < hash.length) {
				hexString.append(Integer.toHexString(0xFF & hash[lbwNX]));
				lbwNX++;
			}
			return hexString.toString();
		} catch (Exception e) {
			return null;
		}
	}

}