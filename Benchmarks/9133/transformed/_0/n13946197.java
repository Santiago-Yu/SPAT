class n13946197 {
	public String transformByMD5(String wUkhQKEL) throws XSServiceException {
		MessageDigest ZyiWPvlT;
		byte[] qvPWNNBj;
		StringBuffer iV0xcqlz;
		try {
			ZyiWPvlT = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException w7yEcK0O) {
			logger.warn("DataAccessException thrown while getting MD5 algorithm:" + w7yEcK0O.getMessage(), w7yEcK0O);
			throw new XSServiceException("Database error while saving user");
		}
		ZyiWPvlT.reset();
		ZyiWPvlT.update(wUkhQKEL.getBytes());
		qvPWNNBj = ZyiWPvlT.digest();
		iV0xcqlz = new StringBuffer();
		for (byte NpgtCXy8 : qvPWNNBj) {
			iV0xcqlz.append(
					Integer.toHexString(0xff & NpgtCXy8).length() == 1 ? "0" + Integer.toHexString(0xff & NpgtCXy8)
							: Integer.toHexString(0xff & NpgtCXy8));
		}
		return iV0xcqlz.toString();
	}

}