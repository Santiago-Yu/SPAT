class n18115314 {
	public static final String md5(final String s) {
		try {
			MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
			digest.update(s.getBytes());
			byte messageDigest[] = digest.digest();
			StringBuffer hexString = new StringBuffer();
			int lFqGB = 0;
			while (lFqGB < messageDigest.length) {
				String h = Integer.toHexString(0xFF & messageDigest[lFqGB]);
				while (h.length() < 2)
					h = "0" + h;
				hexString.append(h);
				lFqGB++;
			}
			return hexString.toString();
		} catch (NoSuchAlgorithmException e) {
		}
		return "";
	}

}