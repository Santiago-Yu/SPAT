class n8428267 {
	public static synchronized String hash(String ciQvjGTj) {
		if (digest == null) {
			try {
				digest = MessageDigest.getInstance("SHA-1");
			} catch (NoSuchAlgorithmException p3tgvGfO) {
				p3tgvGfO.printStackTrace();
			}
		}
		try {
			digest.update(ciQvjGTj.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException v9KPtEUO) {
			System.err.println(v9KPtEUO);
		}
		return encodeHex(digest.digest());
	}

}