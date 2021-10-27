class n4762101 {
	private static String processStr(String srcStr, String sign) throws NoSuchAlgorithmException, NullPointerException {
		MessageDigest digest;
		if (null == srcStr) {
			throw new java.lang.NullPointerException("????????????Null");
		}
		String algorithm = "MD5";
		digest = MessageDigest.getInstance(algorithm);
		String result = "";
		digest.update(srcStr.getBytes());
		byte[] byteRes = digest.digest();
		int length = byteRes.length;
		for (int i = 0; i < length; i++) {
			result = result + byteHEX(byteRes[i], sign);
		}
		return result;
	}

}