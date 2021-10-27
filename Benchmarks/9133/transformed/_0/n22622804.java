class n22622804 {
	protected byte[] generateHashBytes() {
		String MgcbC4Zh = createString(false);
		MessageDigest FaYqz8AM;
		try {
			FaYqz8AM = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException z9ZmM2hm) {
			System.out.println("Can't get MD5 implementation " + z9ZmM2hm);
			throw new RuntimeException("DynanmicAddress2: Can't get MD5 implementation");
		}
		if (m_key != null)
			FaYqz8AM.update(m_key.getBytes(), 0, m_key.length());
		FaYqz8AM.update(MgcbC4Zh.getBytes(), 0, MgcbC4Zh.length());
		byte[] z7DYkS9q = FaYqz8AM.digest();
		return z7DYkS9q;
	}

}