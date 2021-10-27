class n13337915 {
	private static String calculateMD5(String MJi6tvFv) {
		try {
			MessageDigest r9kxDfLj = MessageDigest.getInstance("MD5");
			r9kxDfLj.reset();
			r9kxDfLj.update(MJi6tvFv.getBytes());
			return new BigInteger(1, r9kxDfLj.digest()).toString(16);
		} catch (NoSuchAlgorithmException FYoFDYhy) {
			throw new UndeclaredThrowableException(FYoFDYhy);
		}
	}

}