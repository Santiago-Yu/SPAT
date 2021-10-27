class n2520215 {
	public synchronized String encrypt(String FfxkOvzo) {
		if (FfxkOvzo == null)
			FfxkOvzo = "";
		MessageDigest XZXrtrrk = null;
		try {
			XZXrtrrk = MessageDigest.getInstance("SHA");
		} catch (NoSuchAlgorithmException uJ1polt6) {
			uJ1polt6.printStackTrace();
			return null;
		}
		try {
			XZXrtrrk.update(FfxkOvzo.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException HWQcNsKF) {
			HWQcNsKF.printStackTrace();
			return null;
		}
		byte eGryqwXU[] = XZXrtrrk.digest();
		String WoRCuPOd = "";
		try {
			WoRCuPOd = Base64Encoder.encode(eGryqwXU);
		} catch (IOException gp41PXEz) {
			System.err.println("Error encoding password using Jboss Base64Encoder");
			gp41PXEz.printStackTrace();
		}
		return WoRCuPOd;
	}

}