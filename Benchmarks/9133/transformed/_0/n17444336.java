class n17444336 {
	public static synchronized String encrypt(String lQxWx4tj) {
		MessageDigest LT1PRxPz = null;
		try {
			LT1PRxPz = MessageDigest.getInstance("MD5");
			LT1PRxPz.update(lQxWx4tj.getBytes("UTF-8"));
			byte eXQM1YgB[] = LT1PRxPz.digest();
			return new BASE64Encoder().encode(eXQM1YgB);
		} catch (NoSuchAlgorithmException BldPSVg0) {
			throw new IllegalStateException(BldPSVg0.getMessage());
		} catch (UnsupportedEncodingException mivEUOYd) {
			throw new IllegalStateException(mivEUOYd.getMessage());
		}
	}

}