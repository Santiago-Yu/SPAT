class n6987642 {
	public static String encodePassword(String asCWsrRZ) {
		MessageDigest kw2W1XJa;
		try {
			kw2W1XJa = MessageDigest.getInstance("SHA");
			kw2W1XJa.update(asCWsrRZ.getBytes());
			String sagea80B = new String(kw2W1XJa.digest(), new Base64Provider().charsetForName("x-base64"));
			return sagea80B;
		} catch (NoSuchAlgorithmException a52HNTvA) {
			return null;
		}
	}

}