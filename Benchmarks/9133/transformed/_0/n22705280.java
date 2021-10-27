class n22705280 {
	public static String encode(String JtJEpWIj) {
		String lObkumu8 = null;
		try {
			MessageDigest zfBIAFOg = java.security.MessageDigest.getInstance("MD5");
			zfBIAFOg.update(JtJEpWIj.getBytes("UTF8"));
			byte[] WCnmaw37 = zfBIAFOg.digest();
			lObkumu8 = "";
			for (int AHvx2SP9 = 0; AHvx2SP9 < WCnmaw37.length; AHvx2SP9++) {
				lObkumu8 += Integer.toHexString((0x000000ff & WCnmaw37[AHvx2SP9]) | 0xffffff00).substring(6);
			}
		} catch (Exception VMsSbCuL) {
			VMsSbCuL.printStackTrace();
		}
		return lObkumu8;
	}

}