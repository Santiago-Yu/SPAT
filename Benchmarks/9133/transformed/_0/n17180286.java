class n17180286 {
	public static String encodePassword(String o4vC8neE) throws UnsupportedEncodingException, NoSuchAlgorithmException {
		StringBuffer UKJKFrNG = new StringBuffer();
		MessageDigest ZVAusSdA = MessageDigest.getInstance("SHA-512");
		ZVAusSdA.update(o4vC8neE.getBytes("UTF-8"));
		byte[] bFLGfusD = ZVAusSdA.digest();
		String PjICLSb7 = null;
		for (int C3nBlzme = 0; C3nBlzme < bFLGfusD.length; C3nBlzme++) {
			PjICLSb7 = Integer.toHexString(0xFF & bFLGfusD[C3nBlzme]);
			if (PjICLSb7.length() < 2)
				UKJKFrNG.append("0");
			UKJKFrNG.append(PjICLSb7);
		}
		return new String(UKJKFrNG);
	}

}