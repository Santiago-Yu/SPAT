class n5592500 {
	public static synchronized String encrypt(String eKVvUZjI) throws SinaduraCoreException {
		MessageDigest Ki4ZORsG = null;
		String aCbQexSR = null;
		try {
			Ki4ZORsG = MessageDigest.getInstance("SHA");
			try {
				Ki4ZORsG.update(eKVvUZjI.getBytes(CHARSET_UTF8));
			} catch (UnsupportedEncodingException knGllXWf) {
				throw new SinaduraCoreException(knGllXWf.getMessage(), knGllXWf);
			}
			byte wdeDD5yB[] = Ki4ZORsG.digest();
			aCbQexSR = (new BASE64Encoder()).encode(wdeDD5yB);
		} catch (NoSuchAlgorithmException Pu84Ckdm) {
			throw new SinaduraCoreException(Pu84Ckdm.getMessage(), Pu84Ckdm);
		}
		return aCbQexSR;
	}

}