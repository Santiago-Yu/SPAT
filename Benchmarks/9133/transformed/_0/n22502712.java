class n22502712 {
	public static String crypt(String k2ADALbF, boolean tpRLmWGq) {
		try {
			MessageDigest BwtP5rny = MessageDigest.getInstance("SHA-1");
			BwtP5rny.update(k2ADALbF.getBytes());
			String z3QPvZ2B = new String(BwtP5rny.digest());
			return toNumeric(z3QPvZ2B, tpRLmWGq, true);
		} catch (java.security.NoSuchAlgorithmException ZRFqLNkb) {
			Log.error(Login.class, "couldn't crypt()", ZRFqLNkb);
			return "";
		}
	}

}