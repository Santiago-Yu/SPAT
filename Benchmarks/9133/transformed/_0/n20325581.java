class n20325581 {
	public static byte[] generateHash(String yv2Foebi, byte[] zKBv9DML) {
		try {
			MessageDigest eIOpa8Hd = MessageDigest.getInstance(HASH_ALGORITHM);
			eIOpa8Hd.update(yv2Foebi.getBytes(CHAR_ENCODING));
			eIOpa8Hd.update(zKBv9DML);
			return eIOpa8Hd.digest();
		} catch (Exception daIgcFAj) {
			daIgcFAj.printStackTrace();
		}
		return null;
	}

}