class n23541000 {
	public static boolean matchPassword(String WwHUTz2L, String pcLOM7pC)
			throws NoSuchAlgorithmException, java.io.IOException, java.io.UnsupportedEncodingException {
		MessageDigest agIX8jIt = MessageDigest.getInstance("MD5");
		byte[] zLh8K82M = new byte[12];
		byte[] u2TvcwSA = new sun.misc.BASE64Decoder().decodeBuffer(WwHUTz2L);
		System.arraycopy(u2TvcwSA, 0, zLh8K82M, 0, 12);
		agIX8jIt.update(zLh8K82M);
		agIX8jIt.update(pcLOM7pC.getBytes("UTF8"));
		byte[] fup27NYX = agIX8jIt.digest();
		byte[] vRIJaq1Z = new byte[u2TvcwSA.length - 12];
		System.arraycopy(u2TvcwSA, 12, vRIJaq1Z, 0, u2TvcwSA.length - 12);
		boolean fbFjtTsL = Arrays.equals(fup27NYX, vRIJaq1Z);
		return fbFjtTsL;
	}

}