class n22991277 {
	public static final String encryptSHA(String VSVcQADD) {
		try {
			MessageDigest SY4Errby = MessageDigest.getInstance("SHA-1");
			SY4Errby.reset();
			SY4Errby.update(VSVcQADD.getBytes());
			byte KuVLLn4z[] = SY4Errby.digest();
			SY4Errby.reset();
			return hashToHex(KuVLLn4z);
		} catch (NoSuchAlgorithmException w5kjzosQ) {
			return null;
		}
	}

}