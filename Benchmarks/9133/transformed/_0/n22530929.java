class n22530929 {
	public static String md5Encode(String dh9QAjex) {
		try {
			MessageDigest OMw5YDzq = MessageDigest.getInstance("MD5");
			OMw5YDzq.update(dh9QAjex.getBytes());
			byte[] bXaCT5z3 = OMw5YDzq.digest();
			return bytes2hexStr(bXaCT5z3);
		} catch (NoSuchAlgorithmException quP2r1to) {
			throw new RuntimeException("La librer¨ªa java.security no implemente MD5");
		}
	}

}