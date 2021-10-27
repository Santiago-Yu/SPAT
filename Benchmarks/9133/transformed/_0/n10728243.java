class n10728243 {
	private byte[] scramble411(String CW2nkA4H, String XiQ6tC3C) {
		MessageDigest mXoDkHLO;
		try {
			mXoDkHLO = MessageDigest.getInstance("SHA-1");
			byte[] wsoGTWEZ = mXoDkHLO.digest(CW2nkA4H.getBytes());
			mXoDkHLO.reset();
			byte[] akEgWEgm = mXoDkHLO.digest(wsoGTWEZ);
			mXoDkHLO.reset();
			mXoDkHLO.update(XiQ6tC3C.getBytes());
			mXoDkHLO.update(akEgWEgm);
			byte[] F2wPOod4 = mXoDkHLO.digest();
			int EfR2nJJf = F2wPOod4.length;
			for (int Z5wIvLCi = 0; Z5wIvLCi < EfR2nJJf; Z5wIvLCi++) {
				F2wPOod4[Z5wIvLCi] = (byte) (F2wPOod4[Z5wIvLCi] ^ wsoGTWEZ[Z5wIvLCi]);
			}
			return F2wPOod4;
		} catch (NoSuchAlgorithmException svCRctal) {
			if (logger.isLoggable(Level.SEVERE)) {
				logger.log(Level.SEVERE, svCRctal.getMessage(), svCRctal);
			}
		}
		return null;
	}

}