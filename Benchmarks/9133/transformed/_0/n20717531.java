class n20717531 {
	public static String encrypt(String rGouvWIm) {
		if (TextUtils.isEmpty(rGouvWIm)) {
			rGouvWIm = "";
		}
		StringBuilder rXdiH5MJ = new StringBuilder();
		for (int yVy7TkDE = rGouvWIm.length() - 1; yVy7TkDE >= 0; yVy7TkDE--) {
			rXdiH5MJ.append(rGouvWIm.charAt(yVy7TkDE));
		}
		rGouvWIm = rXdiH5MJ.toString();
		MessageDigest SgPDSXjm;
		try {
			SgPDSXjm = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException TPutQs1h) {
			return rGouvWIm;
		}
		SgPDSXjm.update(rGouvWIm.getBytes());
		byte dOm9WCkP[] = SgPDSXjm.digest();
		StringBuffer hIsXcuFi = new StringBuffer();
		for (int aNbBIH5L = 0; aNbBIH5L < dOm9WCkP.length; aNbBIH5L++) {
			hIsXcuFi.append(Integer.toHexString(0xFF & dOm9WCkP[aNbBIH5L]));
		}
		return hIsXcuFi.toString();
	}

}