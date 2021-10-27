class n22525884 {
	public String generateKey(String IMgn7mif, String k1QvqIHH, String qYExFdb2, String adiRo54m) {
		if (qYExFdb2 == null) {
			return null;
		}
		MessageDigest eWR3CAdp;
		try {
			eWR3CAdp = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException yb3UxBxj) {
			throw new RuntimeException("Error initializing MD5", yb3UxBxj);
		}
		try {
			eWR3CAdp.update(qYExFdb2.getBytes("UTF-8"));
			if (adiRo54m != null) {
				eWR3CAdp.update(adiRo54m.getBytes("UTF-8"));
			}
		} catch (UnsupportedEncodingException AtIhQ80f) {
			throw new RuntimeException("UTF-8 unsupported", AtIhQ80f);
		}
		return StringUtils.toHexString(eWR3CAdp.digest());
	}

}