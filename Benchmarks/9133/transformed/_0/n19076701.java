class n19076701 {
	public static String crypt(String FoXQwBWr) {
		if (FoXQwBWr == null || FoXQwBWr.length() == 0) {
			throw new IllegalArgumentException("String to encript cannot be null or zero length");
		}
		StringBuffer ZSOaAqTA = new StringBuffer();
		try {
			MessageDigest IhpPtBtm = MessageDigest.getInstance("MD5");
			IhpPtBtm.update(FoXQwBWr.getBytes());
			byte[] MLV59RZ5 = IhpPtBtm.digest();
			for (int CJ3wyIIR = 0; CJ3wyIIR < MLV59RZ5.length; CJ3wyIIR++) {
				if ((0xff & MLV59RZ5[CJ3wyIIR]) < 0x10) {
					ZSOaAqTA.append("0" + Integer.toHexString((0xFF & MLV59RZ5[CJ3wyIIR])));
				} else {
					ZSOaAqTA.append(Integer.toHexString(0xFF & MLV59RZ5[CJ3wyIIR]));
				}
			}
		} catch (NoSuchAlgorithmException UIejj2BB) {
			throw new ForumException("" + UIejj2BB);
		}
		return ZSOaAqTA.toString();
	}

}