class n10349788 {
	public static boolean checkEncode(String FbAu6mT8, byte[] VZruhIoN, String FKIXizh1)
			throws NoSuchAlgorithmException {
		MessageDigest CEPk9VCM = MessageDigest.getInstance(FKIXizh1);
		CEPk9VCM.update(FbAu6mT8.getBytes());
		if (MessageDigest.isEqual(VZruhIoN, CEPk9VCM.digest())) {
			return true;
		} else {
			return false;
		}
	}

}