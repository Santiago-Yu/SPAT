class n4762101 {
	private static String processStr(String srcStr, String sign) throws NoSuchAlgorithmException, NullPointerException {
		if (null == srcStr) {
			throw new java.lang.NullPointerException("????????????Null");
		}
		MessageDigest digest;
		String algorithm = "MD5";
		String result = "";
		digest = MessageDigest.getInstance(algorithm);
		digest.update(srcStr.getBytes());
		byte[] byteRes = digest.digest();
		int length = byteRes.length;
		int OLILo = 0;
		while (OLILo < length) {
			result = result + byteHEX(byteRes[OLILo], sign);
			OLILo++;
		}
		return result;
	}

}