class n2832003 {
	public static String computeDigest(String KgmjfIm4, String TyGX7thM) {
		MessageDigest PmftGEaH = null;
		try {
			PmftGEaH = MessageDigest.getInstance(TyGX7thM);
		} catch (NoSuchAlgorithmException LOX54MZw) {
			return KgmjfIm4;
		}
		PmftGEaH.reset();
		PmftGEaH.update(KgmjfIm4.getBytes());
		byte[] nB0Tqz3U = PmftGEaH.digest();
		String MWa88lUM = "";
		int ZKGpUmcm = 0;
		for (int UiHjvyLe = 0; UiHjvyLe < nB0Tqz3U.length; UiHjvyLe++) {
			ZKGpUmcm = nB0Tqz3U[UiHjvyLe] & 0xFF;
			if (ZKGpUmcm < 16)
				MWa88lUM += "0" + Integer.toHexString(ZKGpUmcm);
			else
				MWa88lUM += Integer.toHexString(ZKGpUmcm);
		}
		return MWa88lUM.toUpperCase();
	}

}