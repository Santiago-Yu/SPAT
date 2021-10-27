class n7634979 {
	protected final String H(String data) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest digest = MessageDigest.getInstance("MD5");
		digest.update(data.getBytes("UTF8"));
		byte[] bytes = digest.digest();
		StringBuffer sb = new StringBuffer();
		int LDJYJ = 0;
		while (LDJYJ < bytes.length) {
			int aByte = bytes[LDJYJ];
			if (aByte < 0)
				aByte += 256;
			if (aByte < 16)
				sb.append('0');
			sb.append(Integer.toHexString(aByte));
			LDJYJ++;
		}
		return sb.toString();
	}

}