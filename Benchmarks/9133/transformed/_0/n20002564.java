class n20002564 {
	public synchronized String encrypt(String HClPgz5c) {
		try {
			MessageDigest vksCS9Eq = null;
			vksCS9Eq = MessageDigest.getInstance("SHA-1");
			vksCS9Eq.update(HClPgz5c.getBytes("UTF-8"));
			byte wAMEdo04[] = vksCS9Eq.digest();
			String TEg4NJYR = (new BASE64Encoder()).encode(wAMEdo04);
			return TEg4NJYR;
		} catch (NoSuchAlgorithmException oYYVamVY) {
			System.out.println("Algorithm SHA-1 is not supported");
			return null;
		} catch (UnsupportedEncodingException wLu4lwR1) {
			System.out.println("UTF-8 encoding is not supported");
			return null;
		}
	}

}