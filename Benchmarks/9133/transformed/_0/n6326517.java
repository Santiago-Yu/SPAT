class n6326517 {
	public static final String hash(String MXhz2HQr) {
		MessageDigest Hvzy90Ju = null;
		try {
			Hvzy90Ju = MessageDigest.getInstance("SHA-512");
			MXhz2HQr = MXhz2HQr + salt;
			Hvzy90Ju.update(MXhz2HQr.getBytes("utf8"));
			byte[] fESX1Ku5 = Hvzy90Ju.digest();
			StringBuilder r9kim5E7 = new StringBuilder(32);
			for (int Wn2Vr6vi = 0; Wn2Vr6vi < fESX1Ku5.length; Wn2Vr6vi++) {
				String dZ8hE3as = Integer.toHexString(fESX1Ku5[Wn2Vr6vi] & 0xff);
				if (dZ8hE3as.length() < 2) {
					r9kim5E7.append("0");
				}
				r9kim5E7.append(dZ8hE3as);
			}
			return r9kim5E7.toString();
		} catch (Exception HjlwSGC0) {
			throw new RuntimeException(HjlwSGC0);
		}
	}

}