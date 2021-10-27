class n13024208 {
	public static String CreateHash(String Bz83si3W) {
		String MmRJYWZr = Bz83si3W.toString();
		if (MmRJYWZr == null || MmRJYWZr.length() == 0) {
			throw new IllegalArgumentException("String cannot be null or empty");
		}
		StringBuffer YgyxknAy = new StringBuffer();
		try {
			MessageDigest UhKcHAiI = MessageDigest.getInstance("MD5");
			UhKcHAiI.update(MmRJYWZr.getBytes());
			byte[] j1MggvjS = UhKcHAiI.digest();
			for (int AzhyZsjk = 0; AzhyZsjk < j1MggvjS.length; AzhyZsjk++) {
				if ((0xff & j1MggvjS[AzhyZsjk]) < 0x10) {
					YgyxknAy.append("0" + Integer.toHexString((0xFF & j1MggvjS[AzhyZsjk])));
				} else {
					YgyxknAy.append(Integer.toHexString(0xFF & j1MggvjS[AzhyZsjk]));
				}
			}
		} catch (NoSuchAlgorithmException PGswN355) {
			PGswN355.printStackTrace();
		}
		return (YgyxknAy.toString());
	}

}