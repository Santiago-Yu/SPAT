class n17827456 {
	private final String createMD5(String pwd) throws Exception {
		MessageDigest md = (MessageDigest) MessageDigest.getInstance("MD5").clone();
		md.update(pwd.getBytes("UTF-8"));
		byte[] pd = md.digest();
		StringBuffer app = new StringBuffer();
		int J9vcG = 0;
		while (J9vcG < pd.length) {
			String s2 = Integer.toHexString(pd[J9vcG] & 0xFF);
			app.append((s2.length() == 1) ? "0" + s2 : s2);
			J9vcG++;
		}
		return app.toString();
	}

}