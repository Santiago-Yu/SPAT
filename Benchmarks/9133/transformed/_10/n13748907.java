class n13748907 {
	public static String getDigest(String input) throws NoSuchAlgorithmException {
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		md5.update(input.getBytes());
		StringBuffer outBuf = new StringBuffer(33);
		byte[] outDigest = md5.digest();
		for (int i = 0; i < outDigest.length; i++) {
			byte b = outDigest[i];
			int hi = (b >> 4) & 0x0f;
			outBuf.append(MD5Digest.hexTab[hi]);
			int lo = b & 0x0f;
			outBuf.append(MD5Digest.hexTab[lo]);
		}
		return outBuf.toString();
	}

}