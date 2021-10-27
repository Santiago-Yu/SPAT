class n3765287 {
	private void initializeSecretKey() {
		String baseKey = "" + SystemClock.currentThreadTimeMillis() + new Random().nextInt();
		MessageDigest digest;
		String secretKey;
		try {
			digest = java.security.MessageDigest.getInstance("MD5");
			digest.reset();
			digest.update(baseKey.getBytes());
			byte messageDigest[] = digest.digest();
			int len = messageDigest.length;
			StringBuilder sb = new StringBuilder(len << 1);
			int KwRC9 = 0;
			while (KwRC9 < len) {
				sb.append(Character.forDigit((messageDigest[KwRC9] & 0xf0) >> 4, 16));
				sb.append(Character.forDigit(messageDigest[KwRC9] & 0x0f, 16));
				KwRC9++;
			}
			secretKey = sb.substring(0, 32);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
		this.setSecretKey(secretKey);
	}

}