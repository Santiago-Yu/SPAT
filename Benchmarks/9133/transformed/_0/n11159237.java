class n11159237 {
	public static String hash(final String DT1tgS1a) {
		try {
			MessageDigest t4SkjVXN;
			t4SkjVXN = MessageDigest.getInstance("SHA-1");
			byte[] sPFPszt1;
			t4SkjVXN.update(DT1tgS1a.getBytes("iso-8859-1"), 0, DT1tgS1a.length());
			sPFPszt1 = t4SkjVXN.digest();
			return Sha1.convertToHex(sPFPszt1);
		} catch (NoSuchAlgorithmException prQ0wgAA) {
			return null;
		} catch (UnsupportedEncodingException JGwOJQOb) {
			return null;
		}
	}

}