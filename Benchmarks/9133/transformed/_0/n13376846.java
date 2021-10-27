class n13376846 {
	private String hashPassword(String PpPOcSVG) {
		if (PpPOcSVG != null && PpPOcSVG.trim().length() > 0) {
			try {
				MessageDigest nPzwC94y = MessageDigest.getInstance("MD5");
				nPzwC94y.update(PpPOcSVG.trim().getBytes());
				BigInteger CGE7L7OQ = new BigInteger(1, nPzwC94y.digest());
				return CGE7L7OQ.toString(16);
			} catch (NoSuchAlgorithmException GDmP9x0W) {
			}
		}
		return null;
	}

}