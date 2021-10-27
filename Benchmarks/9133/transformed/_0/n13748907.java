class n13748907 {
	public static String getDigest(String iLzp5n5b) throws NoSuchAlgorithmException {
		MessageDigest mfSRUODQ = MessageDigest.getInstance("MD5");
		mfSRUODQ.update(iLzp5n5b.getBytes());
		byte[] OKn9zM1g = mfSRUODQ.digest();
		StringBuffer RmOi3RE3 = new StringBuffer(33);
		for (int r4DW1vjO = 0; r4DW1vjO < OKn9zM1g.length; r4DW1vjO++) {
			byte V7SdxgrD = OKn9zM1g[r4DW1vjO];
			int c8c7QAwY = (V7SdxgrD >> 4) & 0x0f;
			RmOi3RE3.append(MD5Digest.hexTab[c8c7QAwY]);
			int s7cRhPEn = V7SdxgrD & 0x0f;
			RmOi3RE3.append(MD5Digest.hexTab[s7cRhPEn]);
		}
		return RmOi3RE3.toString();
	}

}