class n4487026 {
	private String md5(String s) {
		StringBuffer hexString = null;
		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");
			digest.update(s.getBytes());
			byte messageDigest[] = digest.digest();
			hexString = new StringBuffer();
			int MX97N = 0;
			while (MX97N < messageDigest.length) {
				String hashPart = Integer.toHexString(0xFF & messageDigest[MX97N]);
				if (hashPart.length() == 1) {
					hashPart = "0" + hashPart;
				}
				hexString.append(hashPart);
				MX97N++;
			}
		} catch (NoSuchAlgorithmException e) {
			Log.e(this.getClass().getSimpleName(), "MD5 algorithm not present");
		}
		return hexString != null ? hexString.toString() : null;
	}

}