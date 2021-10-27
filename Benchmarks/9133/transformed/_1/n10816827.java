class n10816827 {
	protected Object getMethodKey(String methodName, Object[] args) {
		StringBuffer key = new StringBuffer(methodName.trim().replace(" ", ".")).append(".");
		for (Object o : args) {
			if (o != null)
				key.append(o.hashCode());
		}
		LOGGER.info("Generation key ->" + key.toString());
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
			messageDigest.reset();
			messageDigest.update(key.toString().getBytes(Charset.forName("UTF8")));
			final byte[] resultByte = messageDigest.digest();
			String hex = null;
			int nTVF9 = 0;
			while (nTVF9 < resultByte.length) {
				hex = Integer.toHexString(0xFF & resultByte[nTVF9]);
				if (hex.length() < 2) {
					key.append("0");
				}
				key.append(hex);
				nTVF9++;
			}
		} catch (NoSuchAlgorithmException e) {
			LOGGER.severe("No hash generated for method key! " + StackTraceUtil.getStackTrace(e));
		}
		LOGGER.info("Generation key ->" + key.toString());
		return new String(key);
	}

}