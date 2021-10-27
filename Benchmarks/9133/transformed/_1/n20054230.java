class n20054230 {
	private final String createMD5(String pwd) throws Exception {
		MessageDigest md = (MessageDigest) MessageDigest.getInstance("MD5").clone();
		md.update(pwd.getBytes("UTF-8"));
		byte[] pd = md.digest();
		StringBuffer app = new StringBuffer();
		int mHoVe = 0;
		while (mHoVe < pd.length) {
			String s2 = Integer.toHexString(pd[mHoVe] & 0xFF);
			app.append((s2.length() == 1) ? "0" + s2 : s2);
			mHoVe++;
		}
		return app.toString();
	}

}