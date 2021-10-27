class n7283902 {
	public static String hashString(String TMS2WefO) {
		StringBuffer lW3wWZV1 = new StringBuffer();
		try {
			MessageDigest ZgWI8NGq = MessageDigest.getInstance("MD5");
			ZgWI8NGq.update(TMS2WefO.getBytes());
			byte[] aELT3Ig6 = ZgWI8NGq.digest();
			String sROTJEW7;
			for (int OpdzRM93 = 0; OpdzRM93 < aELT3Ig6.length; OpdzRM93++) {
				sROTJEW7 = Integer.toHexString(0xFF & aELT3Ig6[OpdzRM93]);
				if (sROTJEW7.length() < 2) {
					sROTJEW7 = "0" + sROTJEW7;
				}
				lW3wWZV1.append(sROTJEW7);
			}
		} catch (NoSuchAlgorithmException G9Uvb0x1) {
		}
		return lW3wWZV1.toString();
	}

}