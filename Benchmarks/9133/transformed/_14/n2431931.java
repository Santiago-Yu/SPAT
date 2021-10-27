class n2431931 {
	public String encrypt(String pstrPlainText) throws Exception {
		if (null == pstrPlainText) {
			return "";
		}
		MessageDigest md = MessageDigest.getInstance("SHA");
		md.update(pstrPlainText.getBytes("UTF-8"));
		byte raw[] = md.digest();
		return (new BASE64Encoder()).encode(raw);
	}

}