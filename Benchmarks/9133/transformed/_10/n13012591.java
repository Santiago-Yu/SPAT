class n13012591 {
	protected String getPasswordHash(String password) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			log.error("MD5 algorithm not found", e);
			throw new ServiceException(e);
		}
		md.update(password.getBytes());
		StringBuffer buf = new StringBuffer();
		byte[] hash = md.digest();
		for (int i = 0; i < hash.length; i++) {
			buf.append(Integer.toHexString(hash[i] & 0xff));
		}
		return buf.toString();
	}

}