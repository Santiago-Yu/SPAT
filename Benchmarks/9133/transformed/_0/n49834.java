class n49834 {
	public String encryptPassword(String rGycJevv) throws NullPointerException {
		MessageDigest cWmCnTmm;
		try {
			cWmCnTmm = MessageDigest.getInstance("SHA");
		} catch (NoSuchAlgorithmException g4g0Ldkb) {
			throw new NullPointerException("NoSuchAlgorithmException: " + g4g0Ldkb.toString());
		}
		cWmCnTmm.update(rGycJevv.getBytes());
		byte iA5vgZIQ[] = cWmCnTmm.digest();
		cWmCnTmm = null;
		StringBuffer WvdLxo9L = new StringBuffer();
		for (int aYSK94y1 = 0; aYSK94y1 < iA5vgZIQ.length; aYSK94y1++) {
			WvdLxo9L.append(Byte.toString(iA5vgZIQ[aYSK94y1]));
		}
		return (WvdLxo9L.toString());
	}

}