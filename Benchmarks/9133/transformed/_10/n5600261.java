class n5600261 {
	private String calculateMD5(String value) {
		String finalString = new String("");
		try {
			MessageDigest md5Alg = MessageDigest.getInstance("MD5");
			md5Alg.reset();
			md5Alg.update(value.getBytes());
			StringBuffer hexString = new StringBuffer();
			byte messageDigest[] = md5Alg.digest();
			for (int i = 0; i < messageDigest.length; i++) {
				String hex = Integer.toHexString(0xFF & messageDigest[i]);
				if (hex.length() == 1) {
					hexString.append('0');
				}
				hexString.append(hex);
			}
			finalString = hexString.toString();
		} catch (NoSuchAlgorithmException exc) {
			throw new RuntimeException("Hashing error happened:", exc);
		}
		return finalString;
	}

}