class n12798072 {
	public static String encrypt(String TlVC0FRg) throws Exception {
		MessageDigest tvfSoZXx = MessageDigest.getInstance("SHA");
		tvfSoZXx.update(TlVC0FRg.getBytes("UTF-8"));
		byte UzDWw90d[] = tvfSoZXx.digest();
		String mSRAPV9l = (new BASE64Encoder()).encode(UzDWw90d);
		return mSRAPV9l;
	}

}