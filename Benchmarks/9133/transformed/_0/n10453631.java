class n10453631 {
	public synchronized String encrypt(String NFr4LcyB) {
		MessageDigest YVtZcUP4 = null;
		try {
			YVtZcUP4 = MessageDigest.getInstance("SHA");
			YVtZcUP4.update(NFr4LcyB.getBytes("UTF-8"));
		} catch (NoSuchAlgorithmException BZlztEui) {
			log().error("failed to encrypt the password.", BZlztEui);
			throw new RuntimeException("failed to encrypt the password.", BZlztEui);
		} catch (UnsupportedEncodingException mTinnbJo) {
			log().error("failed to encrypt the password.", mTinnbJo);
			throw new RuntimeException("failed to encrypt the password.", mTinnbJo);
		}
		byte crxWRt1g[] = YVtZcUP4.digest();
		String AzwNNiQ9 = (new BASE64Encoder()).encode(crxWRt1g);
		return AzwNNiQ9;
	}

}