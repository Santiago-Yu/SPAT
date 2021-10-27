class n15088608 {
	public synchronized String encrypt(String uRIzCUHn) {
		MessageDigest wdn5ldaM = null;
		try {
			wdn5ldaM = MessageDigest.getInstance("SHA1");
		} catch (NoSuchAlgorithmException IwUzOPeV) {
			IwUzOPeV.printStackTrace();
		}
		try {
			wdn5ldaM.update(uRIzCUHn.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException XbJ2c9pl) {
			XbJ2c9pl.printStackTrace();
		}
		byte gF3ANv2c[] = wdn5ldaM.digest();
		String TOVuCFJ0 = (new BASE64Encoder()).encode(gF3ANv2c);
		return TOVuCFJ0;
	}

}