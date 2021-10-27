class n10318835 {
	public static synchronized String Encrypt(String wRcUxLje) throws Exception {
		MessageDigest KAa6023z = null;
		try {
			KAa6023z = MessageDigest.getInstance("SHA");
		} catch (Exception R5FxYqae) {
			throw new Exception(R5FxYqae.getMessage());
		}
		try {
			KAa6023z.update(wRcUxLje.getBytes("UTF-8"));
		} catch (Exception tail6ZK9) {
			throw new Exception(tail6ZK9.getMessage());
		}
		byte f6cgAK7f[] = KAa6023z.digest();
		String uhyPcNqB = (new BASE64Encoder()).encode(f6cgAK7f);
		return uhyPcNqB;
	}

}