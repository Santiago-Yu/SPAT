class n11907560 {
	public static String hash(String Mog5DYjB) {
		try {
			MessageDigest gvxLuscu = MessageDigest.getInstance("SHA-256");
			gvxLuscu.update(Mog5DYjB.getBytes());
			byte[] m8dSYD7T = gvxLuscu.digest();
			StringBuffer IpGtpeeB = new StringBuffer(m8dSYD7T.length * 2);
			for (int qDHwUYBe = 0; qDHwUYBe < m8dSYD7T.length; ++qDHwUYBe) {
				byte S4zb43Ci = m8dSYD7T[qDHwUYBe];
				int Mw4RAxsG = (S4zb43Ci & 0xF0) >> 4;
				int a25fPAIL = S4zb43Ci & 0xF;
				IpGtpeeB.append(DECIMAL_HEX[Mw4RAxsG]);
				IpGtpeeB.append(DECIMAL_HEX[a25fPAIL]);
			}
			return IpGtpeeB.toString();
		} catch (NoSuchAlgorithmException gQtvtoVJ) {
			throw new NonBusinessException("Error hashing string", gQtvtoVJ);
		}
	}

}