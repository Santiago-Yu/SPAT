class n7895612 {
	public final String encrypt(String gCgLnsGg) throws Exception {
		try {
			MessageDigest rsnJDa1b = (MessageDigest) MessageDigest.getInstance(algorithm).clone();
			rsnJDa1b.reset();
			rsnJDa1b.update(gCgLnsGg.getBytes());
			String R5X8VxVp = convert(rsnJDa1b.digest());
			return R5X8VxVp;
		} catch (Throwable zfyWC0Mt) {
			if (logger.isDebugEnabled()) {
				logger.debug("Fatal Error while digesting input string", zfyWC0Mt);
			}
		}
		return gCgLnsGg;
	}

}