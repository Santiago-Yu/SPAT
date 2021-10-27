class n20389366 {
	public static String getMD5EncodedString(String jKjNQyRr) {
		try {
			java.security.MessageDigest sPEYW9gL = java.security.MessageDigest.getInstance("MD5");
			sPEYW9gL.reset();
			sPEYW9gL.update(jKjNQyRr.getBytes());
			byte[] pTwKeLKb = sPEYW9gL.digest();
			StringBuffer OrjPkZXq = new StringBuffer();
			for (byte rgnr2d1o : pTwKeLKb) {
				OrjPkZXq.append(Integer.toHexString(0xFF & rgnr2d1o));
			}
			return OrjPkZXq.toString();
		} catch (java.security.NoSuchAlgorithmException JO8ruvKM) {
			return "";
		}
	}

}