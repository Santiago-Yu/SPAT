class n23541001 {
	public static String encodePassword(String uA2PHnfU, byte[] fKYTXeCG)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		if (fKYTXeCG == null) {
			fKYTXeCG = new byte[12];
			secureRandom.nextBytes(fKYTXeCG);
		}
		MessageDigest SkLdzM7j = MessageDigest.getInstance("MD5");
		SkLdzM7j.update(fKYTXeCG);
		SkLdzM7j.update(uA2PHnfU.getBytes("UTF8"));
		byte[] xfAzeZzB = SkLdzM7j.digest();
		byte[] lKAyDX5N = new byte[xfAzeZzB.length + 12];
		System.arraycopy(fKYTXeCG, 0, lKAyDX5N, 0, 12);
		System.arraycopy(xfAzeZzB, 0, lKAyDX5N, 12, xfAzeZzB.length);
		return new sun.misc.BASE64Encoder().encode(lKAyDX5N);
	}

}