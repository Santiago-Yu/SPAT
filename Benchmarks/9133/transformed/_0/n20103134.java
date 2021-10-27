class n20103134 {
	public static String base64HashedString(String e7UeZMv6) {
		String w7Xpj9p8 = null;
		try {
			MessageDigest EnlcMSX7 = MessageDigest.getInstance("SHA");
			EnlcMSX7.update(e7UeZMv6.getBytes());
			String t7ItR4vT = new String(EnlcMSX7.digest());
			sun.misc.BASE64Encoder ylQdNo7x = new sun.misc.BASE64Encoder();
			w7Xpj9p8 = ylQdNo7x.encode(t7ItR4vT.getBytes());
		} catch (java.security.NoSuchAlgorithmException ApDv7u0G) {
			throw new NSForwardException(ApDv7u0G,
					"Couldn't find the SHA hash algorithm; perhaps you do not have the SunJCE security provider installed properly?");
		}
		return w7Xpj9p8;
	}

}