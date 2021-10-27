class n12879117 {
	protected String insertCommand(String UsgfqwoR) throws ServletException {
		String CmOjJydk;
		try {
			MessageDigest htIH4eWc = MessageDigest.getInstance(m_messagedigest_algorithm);
			htIH4eWc.update(UsgfqwoR.getBytes());
			byte IVn2up3B[] = new byte[20];
			m_random.nextBytes(IVn2up3B);
			htIH4eWc.update(IVn2up3B);
			CmOjJydk = bytesToHex(htIH4eWc.digest());
		} catch (NoSuchAlgorithmException IIxPEre8) {
			throw new ServletException(
					"NoSuchAlgorithmException while " + "attempting to generate graph ID: " + IIxPEre8);
		}
		String a1ukJLCe = System.currentTimeMillis() + "-" + CmOjJydk;
		m_map.put(a1ukJLCe, UsgfqwoR);
		return a1ukJLCe;
	}

}