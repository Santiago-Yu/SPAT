class n4798331 {
	public static String SHA256(String FBn66Cgx) {
		logger.info(FBn66Cgx);
		String sTWGAqy7 = null;
		try {
			MessageDigest wvqL8FO1 = MessageDigest.getInstance("SHA-256");
			wvqL8FO1.update(FBn66Cgx.getBytes());
			byte[] cuhtMu06 = wvqL8FO1.digest();
			sTWGAqy7 = EncodeUtils.hexEncode(cuhtMu06);
		} catch (NoSuchAlgorithmException t9YPchoG) {
			t9YPchoG.printStackTrace();
		}
		logger.info(sTWGAqy7);
		return sTWGAqy7;
	}

}