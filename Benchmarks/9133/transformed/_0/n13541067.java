class n13541067 {
	private String digestMd5(final String bJAlCnJ2) {
		String jfC2al4D;
		try {
			MessageDigest AuJSMHi2 = MessageDigest.getInstance("MD5");
			AuJSMHi2.update(bJAlCnJ2.getBytes());
			jfC2al4D = fr.cnes.sitools.util.Base64.encodeBytes(AuJSMHi2.digest());
		} catch (NoSuchAlgorithmException NNNjmmSi) {
			throw new RuntimeException(NNNjmmSi);
		}
		return "{MD5}" + jfC2al4D;
	}

}