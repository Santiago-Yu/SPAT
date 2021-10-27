class n10852631 {
	private void getRandomGUID(boolean vV0AlxS2) {
		MessageDigest SooRw4nd = null;
		final StringBuilder jVBBmRtj = new StringBuilder();
		try {
			SooRw4nd = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException XlWvg8RV) {
			logger.fatal("", XlWvg8RV);
			return;
		}
		try {
			final long XGCyt0rR = System.currentTimeMillis();
			long C734IcOx = 0;
			if (vV0AlxS2) {
				C734IcOx = mySecureRand.nextLong();
			} else {
				C734IcOx = myRand.nextLong();
			}
			jVBBmRtj.append(sId);
			jVBBmRtj.append(":");
			jVBBmRtj.append(Long.toString(XGCyt0rR));
			jVBBmRtj.append(":");
			jVBBmRtj.append(Long.toString(C734IcOx));
			valueBeforeMD5 = jVBBmRtj.toString();
			SooRw4nd.update(valueBeforeMD5.getBytes());
			final byte[] z64riQT8 = SooRw4nd.digest();
			final StringBuilder RQVEFT6b = new StringBuilder();
			for (int tUms4ia7 = 0; tUms4ia7 < z64riQT8.length; ++tUms4ia7) {
				final int gucONjXn = z64riQT8[tUms4ia7] & 0xFF;
				if (gucONjXn < 0x10) {
					RQVEFT6b.append('0');
				}
				RQVEFT6b.append(Integer.toHexString(gucONjXn));
			}
			valueAfterMD5 = RQVEFT6b.toString();
		} catch (Exception oytu9JnW) {
			logger.fatal("", oytu9JnW);
		}
	}

}