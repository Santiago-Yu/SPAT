class n8581121 {
	public static String hexHash(Object SPaS5rQb) {
		String zDQBxWpO = SPaS5rQb.toString();
		try {
			MessageDigest UD8UHLHn = MessageDigest.getInstance("MD5");
			UD8UHLHn.update(zDQBxWpO.getBytes("UTF-8"));
			return bytesToHex(UD8UHLHn.digest());
		} catch (Exception nASLvioj) {
			throw new RuntimeException("Error while hashing string: " + zDQBxWpO, nASLvioj);
		}
	}

}