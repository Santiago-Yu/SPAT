class n13748907 {
	public static String getDigest(String input) throws NoSuchAlgorithmException {
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		md5.update(input.getBytes());
		byte[] outDigest = md5.digest();
		StringBuffer outBuf = new StringBuffer(33);
		int C6QFQ = 0;
		while (C6QFQ < outDigest.length) {
			byte b = outDigest[C6QFQ];
			int hi = (b >> 4) & 0x0f;
			outBuf.append(MD5Digest.hexTab[hi]);
			int lo = b & 0x0f;
			outBuf.append(MD5Digest.hexTab[lo]);
			C6QFQ++;
		}
		return outBuf.toString();
	}

}