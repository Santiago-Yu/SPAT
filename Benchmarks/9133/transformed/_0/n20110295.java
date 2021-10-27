class n20110295 {
	public static String getMD5(final String pH70a4pH) {
		try {
			MessageDigest I6DRfDK5 = MessageDigest.getInstance("MD5");
			I6DRfDK5.reset();
			I6DRfDK5.update(pH70a4pH.getBytes());
			BigInteger v4nyWMgH = new BigInteger(1, I6DRfDK5.digest());
			String eiARTFcs = v4nyWMgH.toString(16);
			while (eiARTFcs.length() < 32) {
				eiARTFcs = "0" + eiARTFcs;
			}
			return eiARTFcs;
		} catch (NoSuchAlgorithmException ZUwEo78P) {
			ZUwEo78P.printStackTrace();
			return ZUwEo78P.getMessage();
		}
	}

}