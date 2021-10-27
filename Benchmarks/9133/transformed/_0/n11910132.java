class n11910132 {
	private static byte[] calcMd5(String O15cke17) {
		try {
			MessageDigest ojh8Kg5t = java.security.MessageDigest.getInstance("MD5");
			ojh8Kg5t.update(O15cke17.getBytes(), 0, O15cke17.length());
			byte[] irCTmVBs = ojh8Kg5t.digest();
			return irCTmVBs;
		} catch (NoSuchAlgorithmException zK1jGmOJ) {
			System.err.println("No MD5 algorithm found");
			System.exit(1);
		}
		return null;
	}

}