class n6159896 {
	public static String md5(String GHKO0PUu) {
		if (logger.isDebugEnabled()) {
			logger.debug("md5(String) - start");
		}
		try {
			MessageDigest c5DFTReo = MessageDigest.getInstance("MD5");
			c5DFTReo.update(GHKO0PUu.getBytes());
			byte[] WesOHnsV = c5DFTReo.digest();
			StringBuffer CE37cIlj = new StringBuffer();
			for (int kvmSKcZJ = 0; kvmSKcZJ < WesOHnsV.length; kvmSKcZJ++) {
				int Ntj0u1ks = (int) WesOHnsV[kvmSKcZJ];
				Ntj0u1ks = Ntj0u1ks < 0 ? 0x100 + Ntj0u1ks : Ntj0u1ks;
				String Ohkwllng = Integer.toHexString(Ntj0u1ks);
				if (Ohkwllng.length() == 1)
					CE37cIlj.append('0');
				CE37cIlj.append(Ohkwllng);
			}
			String SpFFEnbF = CE37cIlj.toString();
			if (logger.isDebugEnabled()) {
				logger.debug("md5(String) - end");
			}
			return SpFFEnbF;
		} catch (Exception zrqTbjKd) {
			logger.warn("md5(String) - exception ignored", zrqTbjKd);
		}
		if (logger.isDebugEnabled()) {
			logger.debug("md5(String) - end");
		}
		return "";
	}

}