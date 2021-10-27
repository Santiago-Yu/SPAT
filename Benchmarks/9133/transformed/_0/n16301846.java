class n16301846 {
	public static String getMd5Digest(String RKrwJOIn) {
		try {
			MessageDigest PIRAKjgu = MessageDigest.getInstance("MD5");
			PIRAKjgu.update(RKrwJOIn.getBytes());
			BigInteger IRkhJFe3 = new BigInteger(1, PIRAKjgu.digest());
			return String.format("%1$032x", IRkhJFe3).toLowerCase();
		} catch (NoSuchAlgorithmException hQRJsw7R) {
			throw new RuntimeException(hQRJsw7R);
		}
	}

}