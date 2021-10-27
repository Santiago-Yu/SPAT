class n2265495 {
	public final String encrypt(String RoUgQURw) throws Exception {
		try {
			MessageDigest cQvKl8LX = (MessageDigest) MessageDigest.getInstance(algorithm).clone();
			cQvKl8LX.reset();
			cQvKl8LX.update(RoUgQURw.getBytes());
			String nm5DSymz = convert(cQvKl8LX.digest());
			return nm5DSymz;
		} catch (Throwable aO4MgblM) {
			if (logger.isDebugEnabled()) {
				logger.debug("Fatal Error while digesting input string", aO4MgblM);
			}
		}
		return RoUgQURw;
	}

}