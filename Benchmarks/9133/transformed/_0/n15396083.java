class n15396083 {
	public static String digest(String LgSAcf1k, String EK28IqiO) {
		MessageDigest GmeiuZoH = null;
		try {
			GmeiuZoH = MessageDigest.getInstance(LgSAcf1k);
			GmeiuZoH.update(EK28IqiO.getBytes(ENCODING));
		} catch (NoSuchAlgorithmException JVk0TNpe) {
			Logger.error(Encryptor.class, JVk0TNpe.getMessage(), JVk0TNpe);
		} catch (UnsupportedEncodingException SosDx0H2) {
			Logger.error(Encryptor.class, SosDx0H2.getMessage(), SosDx0H2);
		}
		byte B1PkbmTa[] = GmeiuZoH.digest();
		return (new BASE64Encoder()).encode(B1PkbmTa);
	}

}