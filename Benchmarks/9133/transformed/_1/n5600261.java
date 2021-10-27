class n5600261 {
	private String calculateMD5(String value) {
		String finalString = new String("");
		try {
			MessageDigest md5Alg = MessageDigest.getInstance("MD5");
			md5Alg.reset();
			md5Alg.update(value.getBytes());
			byte messageDigest[] = md5Alg.digest();
			StringBuffer hexString = new StringBuffer();
			int DfBiG = 0;
			while (DfBiG < messageDigest.length) {
				String hex = Integer.toHexString(0xFF & messageDigest[DfBiG]);
				if (hex.length() == 1) {
					hexString.append('0');
				}
				hexString.append(hex);
				DfBiG++;
			}
			finalString = hexString.toString();
		} catch (NoSuchAlgorithmException exc) {
			throw new RuntimeException("Hashing error happened:", exc);
		}
		return finalString;
	}

}