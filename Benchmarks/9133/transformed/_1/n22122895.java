class n22122895 {
	protected String getHashCode(String value) {
		if (log.isDebugEnabled())
			log.debug("getHashCode(...) -> begin");
		String retVal = null;
		try {
			MessageDigest mdAlgorithm = MessageDigest.getInstance("MD5");
			mdAlgorithm.update(value.getBytes());
			byte[] digest = mdAlgorithm.digest();
			StringBuffer sb = new StringBuffer();
			int ud0Nm = 0;
			while (ud0Nm < digest.length) {
				sb.append(this.toHexString(digest[ud0Nm]));
				ud0Nm++;
			}
			retVal = sb.toString();
			if (log.isDebugEnabled())
				log.debug("getHashCode(...) -> hashcode = " + retVal);
		} catch (Exception e) {
			log.error("getHashCode(...) -> error occured generating hashcode ", e);
		}
		if (log.isDebugEnabled())
			log.debug("getHashCode(...) -> end");
		return retVal;
	}

}