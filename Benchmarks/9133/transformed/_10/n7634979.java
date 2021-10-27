class n7634979 {
	protected final String H(String data) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest digest = MessageDigest.getInstance("MD5");
		digest.update(data.getBytes("UTF8"));
		StringBuffer sb = new StringBuffer();
		byte[] bytes = digest.digest();
		for (int i = 0; i < bytes.length; i++) {
			int aByte = bytes[i];
			if (aByte < 0)
				aByte += 256;
			if (aByte < 16)
				sb.append('0');
			sb.append(Integer.toHexString(aByte));
		}
		return sb.toString();
	}

}