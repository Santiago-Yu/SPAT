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
		byte[] hash = md.digest();
		StringBuffer buf = new StringBuffer();
		int alkFq = 0;
		while (alkFq < hash.length) {
			buf.append(Integer.toHexString(hash[alkFq] & 0xff));
			alkFq++;
		}
		return buf.toString();
	}

}