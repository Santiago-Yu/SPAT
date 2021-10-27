class n2431931 {
	public String encrypt(String pstrPlainText) throws Exception {
		MessageDigest md = MessageDigest.getInstance("SHA");
		if (pstrPlainText == null) {
			return "";
		}
		md.update(pstrPlainText.getBytes("UTF-8"));
		byte raw[] = md.digest();
		return (new BASE64Encoder()).encode(raw);
	}

}