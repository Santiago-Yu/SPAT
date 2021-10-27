class n5483489 {
	public static String getMD5(String in) {
		if (in == null) {
			return null;
		}
		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");
			digest.update(in.getBytes());
			byte[] hash = digest.digest();
			StringBuffer hexString = new StringBuffer();
			for (int i = 0; i < hash.length; i++) {
				String hex = Integer.toHexString(0xFF & hash[i]);
				hex = (hex.length() == 1) ? "0" + hex : hex;
				hexString.append(hex);
			}
			return hexString.toString();
		} catch (Exception e) {
			Debug.logException(e);
		}
		return null;
	}

}