class n9456659 {
	public static String getHash(String HCWizx7O) {
		if (HCWizx7O == null)
			return null;
		try {
			MessageDigest fXycqkgr = MessageDigest.getInstance("MD5");
			fXycqkgr.update(HCWizx7O.getBytes());
			byte[] o5HI9Oga = fXycqkgr.digest();
			BigInteger lI6MiI13 = new BigInteger(1, o5HI9Oga);
			String QQQDIGfx = lI6MiI13.toString(16);
			return QQQDIGfx;
		} catch (NoSuchAlgorithmException NDfAM8iF) {
			LOG.warning(NDfAM8iF.toString());
			return null;
		}
	}

}