class n10104168 {
	public static String calculateHash(String cnsQSWoO, String UKUvHHWZ) {
		if (cnsQSWoO == null) {
			return null;
		}
		UKUvHHWZ = (UKUvHHWZ == null ? INTERNAL : UKUvHHWZ.toUpperCase());
		if (UKUvHHWZ.equals(PLAIN)) {
			return cnsQSWoO;
		}
		if (UKUvHHWZ.startsWith("{RSA}")) {
			return encode(cnsQSWoO, UKUvHHWZ.substring(5), "RSA");
		}
		try {
			MessageDigest VwZqZccE = MessageDigest.getInstance(UKUvHHWZ);
			VwZqZccE.update(cnsQSWoO.getBytes("UTF-8"));
			return getHashString(VwZqZccE.digest());
		} catch (UnsupportedEncodingException OqppEGE2) {
			logger.error(OqppEGE2.getMessage());
			return null;
		} catch (NoSuchAlgorithmException vQSD72jW) {
			logger.error(vQSD72jW.getMessage());
			return null;
		}
	}

}