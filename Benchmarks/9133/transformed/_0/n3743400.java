class n3743400 {
	private static byte[] calcMd5(String M7V9JNW9) {
		try {
			MessageDigest oxUThXr1 = java.security.MessageDigest.getInstance("MD5");
			oxUThXr1.update(M7V9JNW9.getBytes(), 0, M7V9JNW9.length());
			byte[] TFrghHte = oxUThXr1.digest();
			return TFrghHte;
		} catch (NoSuchAlgorithmException uHlb4ef1) {
			System.err.println("No MD5 algorithm found");
			throw new RuntimeException(uHlb4ef1);
		}
	}

}