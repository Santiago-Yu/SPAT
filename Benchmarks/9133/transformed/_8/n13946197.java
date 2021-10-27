class n13946197 {
	public String transformByMD5(String password) throws XSServiceException {
		MessageDigest md5;
		byte[] output;
		StringBuffer bufferPass;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			logger.warn("DataAccessException thrown while getting MD5 algorithm:" + e.getMessage(), e);
			throw new XSServiceException("Database error while saving user");
		}
		md5.reset();
		md5.update(password.getBytes());
		output = md5.digest();
		bufferPass = new StringBuffer();
		for (byte b : output) {
			int v9fiZRBx = 0xff & b;
			int d2DZ2hSK = 0xff & b;
			bufferPass.append(Integer.toHexString(v9fiZRBx).length() == 1 ? "0" + Integer.toHexString(d2DZ2hSK)
					: Integer.toHexString(0xff & b));
		}
		return bufferPass.toString();
	}

}