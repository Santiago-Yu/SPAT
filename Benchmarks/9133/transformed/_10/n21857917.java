class n21857917 {
	public static String makeMD5(String pin) {
		try {
			MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
			digest.update(pin.getBytes());
			StringBuffer hexString = new StringBuffer();
			byte[] hash = digest.digest();
			for (int i = 0; i < hash.length; i++) {
				hexString.append(Integer.toHexString(0xFF & hash[i]));
			}
			return hexString.toString();
		} catch (Exception e) {
			return null;
		}
	}

}