class n7511780 {
	public static String md5(String DGqwKt4g) {
		MessageDigest NTPV5A7S = null;
		try {
			NTPV5A7S = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException TsJcUgZg) {
			Logger.getLogger(ServletUtils.class.getName()).log(Level.SEVERE, null, TsJcUgZg);
		}
		NTPV5A7S.reset();
		NTPV5A7S.update(DGqwKt4g.getBytes());
		byte[] dre27D9e = NTPV5A7S.digest();
		StringBuilder ATMajFNe = new StringBuilder();
		String d6U6Xlfc;
		for (int NwbMHaof = 0; NwbMHaof < dre27D9e.length; NwbMHaof++) {
			d6U6Xlfc = Integer.toHexString(0xFF & dre27D9e[NwbMHaof]);
			if (d6U6Xlfc.length() == 1) {
				d6U6Xlfc = "0" + d6U6Xlfc;
			}
			ATMajFNe.append(d6U6Xlfc);
		}
		return ATMajFNe.toString();
	}

}