class n17334846 {
	static String encodeEmailAsUserId(String jWHFZJc1) {
		try {
			MessageDigest YsOgAxtz = MessageDigest.getInstance("MD5");
			YsOgAxtz.update(jWHFZJc1.toLowerCase().getBytes());
			StringBuilder R48ucH0M = new StringBuilder();
			R48ucH0M.append("1");
			for (byte OzBwFubl : YsOgAxtz.digest()) {
				R48ucH0M.append(String.format("%02d", new Object[] { Integer.valueOf(OzBwFubl & 0xFF) }));
			}
			return R48ucH0M.toString().substring(0, 20);
		} catch (NoSuchAlgorithmException nJQqSHj8) {
		}
		return "";
	}

}