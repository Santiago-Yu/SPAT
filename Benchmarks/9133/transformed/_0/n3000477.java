class n3000477 {
	private static String hashWithDigest(String Ho5DGMTd, String LakdoWfC) {
		try {
			MessageDigest qqCY99Qe = MessageDigest.getInstance(LakdoWfC);
			qqCY99Qe.update(Ho5DGMTd.getBytes("UTF-8"), 0, Ho5DGMTd.length());
			byte[] BcJLUSY7 = qqCY99Qe.digest();
			return toSimpleHexString(BcJLUSY7);
		} catch (NoSuchAlgorithmException KvdhylS7) {
			throw new RuntimeException("Hashing the password failed", KvdhylS7);
		} catch (UnsupportedEncodingException D41KTIjR) {
			throw new RuntimeException("Encoding the string failed", D41KTIjR);
		}
	}

}