class n14284458 {
	private String md5(String A6ObQzfk) {
		try {
			MessageDigest d9SiH9ZO = MessageDigest.getInstance("MD5");
			d9SiH9ZO.update(A6ObQzfk.getBytes(), 0, A6ObQzfk.length());
			return new BigInteger(1, d9SiH9ZO.digest()).toString(16);
		} catch (Exception zVnJl0LC) {
			return "BAD MD5";
		}
	}

}