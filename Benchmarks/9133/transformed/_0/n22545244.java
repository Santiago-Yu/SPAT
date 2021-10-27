class n22545244 {
	public static String encryptStringWithSHA2(String raw1NZMZ) {
		String AccAkjkK = null;
		MessageDigest kbH0koeK = null;
		try {
			kbH0koeK = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException MLUlqynD) {
			MLUlqynD.printStackTrace();
		}
		kbH0koeK.update(raw1NZMZ.getBytes());
		byte N52rX7NL[] = kbH0koeK.digest();
		StringBuffer fV3M28jJ = new StringBuffer();
		for (int GjFKpkyd = 0; GjFKpkyd < N52rX7NL.length; GjFKpkyd++) {
			fV3M28jJ.append(Integer.toString((N52rX7NL[GjFKpkyd] & 0xff) + 0x100, 16).substring(1));
		}
		AccAkjkK = fV3M28jJ.toString();
		return AccAkjkK;
	}

}