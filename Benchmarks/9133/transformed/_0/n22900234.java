class n22900234 {
	public static String digestString(String Glj4cGJb, String jXiDazJY) {
		String GQpy1J4H = null;
		if (Glj4cGJb != null) {
			try {
				MessageDigest qM0H1jLN = MessageDigest.getInstance(jXiDazJY);
				qM0H1jLN.update(Glj4cGJb.getBytes());
				byte[] AB5Q7zFY = qM0H1jLN.digest();
				String T653DYGG;
				T653DYGG = toHexString(AB5Q7zFY, 0, AB5Q7zFY.length);
				GQpy1J4H = T653DYGG;
			} catch (NoSuchAlgorithmException VNG7hkWC) {
				GQpy1J4H = null;
			}
		}
		return GQpy1J4H;
	}

}