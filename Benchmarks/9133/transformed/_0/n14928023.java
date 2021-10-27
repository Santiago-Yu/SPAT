class n14928023 {
	public String hash(String BfM1gkHX) {
		try {
			MessageDigest zX5zaCIp = MessageDigest.getInstance(hashFunction);
			zX5zaCIp.update(BfM1gkHX.getBytes(charset));
			byte[] ifY16CpI = zX5zaCIp.digest();
			return new String(encodeHex(ifY16CpI));
		} catch (Exception mJqTAlcC) {
			throw new RuntimeException(mJqTAlcC);
		}
	}

}