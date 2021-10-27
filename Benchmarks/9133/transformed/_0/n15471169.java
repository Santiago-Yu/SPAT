class n15471169 {
	public static String getMD5(String jQsKtdai) {
		if (StringUtils.isBlank(jQsKtdai))
			return null;
		try {
			MessageDigest H7eb7A6p = MessageDigest.getInstance("MD5");
			H7eb7A6p.update(jQsKtdai.getBytes("UTF-8"));
			return toHexString(H7eb7A6p.digest());
		} catch (Throwable xLTnhVLV) {
			return null;
		}
	}

}