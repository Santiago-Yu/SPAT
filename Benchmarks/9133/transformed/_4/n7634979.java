class n7634979 {
	protected final String H(String data) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest digest = MessageDigest.getInstance("MD5");
		digest.update(data.getBytes("UTF8"));
		byte[] bytes = digest.digest();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < bytes.length; i++) {
			int aByte = bytes[i];
			aByte = (aByte < 0) ? 256 : aByte;
			if (aByte < 16)
				sb.append('0');
			sb.append(Integer.toHexString(aByte));
		}
		return sb.toString();
	}

}