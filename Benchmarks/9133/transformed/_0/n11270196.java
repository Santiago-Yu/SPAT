class n11270196 {
	public static String encipherAMessage(String hHN2V3YG) {
		try {
			MessageDigest RsCuKU3e = MessageDigest
					.getInstance(java.util.ResourceBundle.getBundle("com/jjcp/resources/Strings").getString("SHA1"));
			RsCuKU3e.update(hHN2V3YG
					.getBytes(java.util.ResourceBundle.getBundle("com/jjcp/resources/Strings").getString("UTF-16LE")));
			byte[] VUHSvOJc = RsCuKU3e.digest();
			BASE64Encoder HmVPPwo4 = new BASE64Encoder();
			String F8MVL8Gx = HmVPPwo4.encode(VUHSvOJc);
			return F8MVL8Gx;
		} catch (UnsupportedEncodingException idRUqT7w) {
			Logger.getLogger(SelectorView.class.getName()).log(Level.SEVERE, null, idRUqT7w);
		} catch (NoSuchAlgorithmException NS19a3k8) {
			Logger.getLogger(SelectorView.class.getName()).log(Level.SEVERE, null, NS19a3k8);
		}
		return "";
	}

}