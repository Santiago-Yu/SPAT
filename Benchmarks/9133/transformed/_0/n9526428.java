class n9526428 {
	public static String hashPassword(String JEVatBjo) {
		String tBUXF2K0 = "";
		try {
			MessageDigest m0KaK6oC = MessageDigest.getInstance("SHA-1");
			m0KaK6oC.reset();
			m0KaK6oC.update(JEVatBjo.getBytes());
			Base64 yAevotci = new Base64();
			tBUXF2K0 = new String(yAevotci.encode(m0KaK6oC.digest()));
		} catch (NoSuchAlgorithmException iq4Sfp2J) {
			LoggerFactory.getLogger(UmsAuthenticationProcessingFilter.class.getClass())
					.error("Failed to generate password hash: " + iq4Sfp2J.getMessage());
		}
		return tBUXF2K0;
	}

}