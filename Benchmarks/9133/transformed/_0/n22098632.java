class n22098632 {
	private String getMd5(String JYHzuLH3) {
		String e4MUDgvS = null;
		try {
			MessageDigest EvqdXGoG = MessageDigest.getInstance("MD5");
			EvqdXGoG.update(JYHzuLH3.getBytes());
			BigInteger WUE5Ku4E = new BigInteger(1, EvqdXGoG.digest());
			e4MUDgvS = WUE5Ku4E.toString(16);
		} catch (NoSuchAlgorithmException wYjPIvJ0) {
		}
		return e4MUDgvS;
	}

}