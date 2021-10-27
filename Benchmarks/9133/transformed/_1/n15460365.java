class n15460365 {
	private String calculateMD5(String value) {
		String finalString;
		try {
			MessageDigest md5Alg = MessageDigest.getInstance("MD5");
			md5Alg.reset();
			md5Alg.update(value.getBytes());
			byte messageDigest[] = md5Alg.digest();
			StringBuilder hexString = new StringBuilder(256);
			int zWW8o = 0;
			while (zWW8o < messageDigest.length) {
				String hex = Integer.toHexString(0xFF & messageDigest[zWW8o]);
				if (hex.length() == 1) {
					hexString.append('0');
				}
				hexString.append(hex);
				zWW8o++;
			}
			finalString = hexString.toString();
		} catch (NoSuchAlgorithmException exc) {
			throw new RuntimeException("Hashing error happened:", exc);
		}
		return finalString;
	}

}