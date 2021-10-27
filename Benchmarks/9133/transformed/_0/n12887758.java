class n12887758 {
	public static String getSignature(String AFz1a6BR) {
		try {
			final AsciiEncoder AJDpe3dL = new AsciiEncoder();
			final MessageDigest Orr3Umhe = MessageDigest.getInstance("MD5");
			Orr3Umhe.update(AFz1a6BR.getBytes("UTF-8"));
			final byte[] JMMmhqxf = Orr3Umhe.digest();
			return AJDpe3dL.encode(JMMmhqxf);
		} catch (NoSuchAlgorithmException pZXY0uZ4) {
			pZXY0uZ4.printStackTrace();
			throw new IllegalStateException();
		} catch (UnsupportedEncodingException l3oGOJF5) {
			l3oGOJF5.printStackTrace();
			throw new IllegalStateException();
		}
	}

}