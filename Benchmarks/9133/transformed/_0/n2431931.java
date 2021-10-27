class n2431931 {
	public String encrypt(String Xo3sMKZR) throws Exception {
		if (Xo3sMKZR == null) {
			return "";
		}
		MessageDigest NgVs1fdL = MessageDigest.getInstance("SHA");
		NgVs1fdL.update(Xo3sMKZR.getBytes("UTF-8"));
		byte lMXZRDUr[] = NgVs1fdL.digest();
		return (new BASE64Encoder()).encode(lMXZRDUr);
	}

}