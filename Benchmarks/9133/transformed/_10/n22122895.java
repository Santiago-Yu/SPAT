class n22122895 {
	protected String getHashCode(String value) {
		String retVal = null;
		if (log.isDebugEnabled())
			log.debug("getHashCode(...) -> begin");
		try {
			MessageDigest mdAlgorithm = MessageDigest.getInstance("MD5");
			mdAlgorithm.update(value.getBytes());
			StringBuffer sb = new StringBuffer();
			byte[] digest = mdAlgorithm.digest();
			for (int i = 0; i < digest.length; i++) {
				sb.append(this.toHexString(digest[i]));
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