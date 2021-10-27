class n14412812 {
	public static String getMD5(String FwFt5MJm) throws NoSuchAlgorithmException {
		MessageDigest LBUUxGAR = MessageDigest.getInstance("MD5");
		LBUUxGAR.update(FwFt5MJm.getBytes());
		byte[] IrmADXtV = LBUUxGAR.digest();
		StringBuffer fFwOOgDW = new StringBuffer();
		for (byte bPEty5J9 : IrmADXtV) {
			fFwOOgDW.append((Integer.toHexString((bPEty5J9 & 0xFF) | 0x100)).substring(1, 3));
		}
		return fFwOOgDW.toString();
	}

}