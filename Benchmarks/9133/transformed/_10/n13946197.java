class n13946197 {
	public String transformByMD5(String password) throws XSServiceException {
		byte[] output;
		MessageDigest md5;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			logger.warn("DataAccessException thrown while getting MD5 algorithm:" + e.getMessage(), e);
			throw new XSServiceException("Database error while saving user");
		}
		StringBuffer bufferPass;
		md5.reset();
		md5.update(password.getBytes());
		bufferPass = new StringBuffer();
		output = md5.digest();
		for (byte b : output) {
			bufferPass.append(Integer.toHexString(0xff & b).length() == 1 ? "0" + Integer.toHexString(0xff & b)
					: Integer.toHexString(0xff & b));
		}
		return bufferPass.toString();
	}

}