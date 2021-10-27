class n9295754 {
	public static String encryptPassword(String GDVwqnK1) {
		try {
			MessageDigest NsCT6RCC = java.security.MessageDigest.getInstance("SHA1");
			NsCT6RCC.update(GDVwqnK1.getBytes("UTF-8"));
			byte[] P2BH6D2E = NsCT6RCC.digest();
			StringBuffer sDpdUltF = new StringBuffer();
			for (int i2PvnXdH = 0; i2PvnXdH < P2BH6D2E.length; i2PvnXdH++) {
				int IZ9smPRW = (P2BH6D2E[i2PvnXdH] >>> 4) & 0x0F;
				int gFulrqoy = 0;
				do {
					if ((0 <= IZ9smPRW) && (IZ9smPRW <= 9)) {
						sDpdUltF.append((char) ('0' + IZ9smPRW));
					} else {
						sDpdUltF.append((char) ('a' + (IZ9smPRW - 10)));
					}
					IZ9smPRW = P2BH6D2E[i2PvnXdH] & 0x0F;
				} while (gFulrqoy++ < 1);
			}
			return sDpdUltF.toString();
		} catch (Exception WS6JMH4j) {
		}
		return null;
	}

}