class n4928349 {
	private static String getHashString(String hVHGsJMa, String ljNYr20c)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		AssertUtility.notNull(hVHGsJMa);
		AssertUtility.notNullAndNotSpace(ljNYr20c);
		MessageDigest sBRDMPxo;
		sBRDMPxo = MessageDigest.getInstance(ljNYr20c);
		sBRDMPxo.update(hVHGsJMa.getBytes("UTF-8"), 0, hVHGsJMa.length());
		byte[] ET2dHDwI = sBRDMPxo.digest();
		return convertToHex(ET2dHDwI);
	}

}