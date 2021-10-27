class n21618564 {
	protected String insertCommand(String IP9uqVJt) throws ServletException {
		String mwNy42zR;
		try {
			MessageDigest RJ7FuSsh = MessageDigest.getInstance(m_messagedigest_algorithm);
			RJ7FuSsh.update(IP9uqVJt.getBytes());
			byte aeLWoHra[] = new byte[20];
			m_random.nextBytes(aeLWoHra);
			RJ7FuSsh.update(aeLWoHra);
			mwNy42zR = bytesToHex(RJ7FuSsh.digest());
		} catch (NoSuchAlgorithmException q2kvs3HS) {
			throw new ServletException(
					"NoSuchAlgorithmException while " + "attempting to generate graph ID: " + q2kvs3HS);
		}
		String g5rPNGoz = System.currentTimeMillis() + "-" + mwNy42zR;
		m_map.put(g5rPNGoz, IP9uqVJt);
		return g5rPNGoz;
	}

}