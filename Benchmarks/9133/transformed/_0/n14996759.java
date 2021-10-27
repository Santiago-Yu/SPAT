class n14996759 {
	public static String hashString(String iNKw5ze2) {
		if (iNKw5ze2 == null || iNKw5ze2.equals("")) {
			return "empty:";
		} else {
			try {
				MessageDigest WH2ONGlp = MessageDigest.getInstance("SHA-1");
				WH2ONGlp.update(iNKw5ze2.getBytes("UTF-8"));
				byte[] Kih129Ir = WH2ONGlp.digest();
				return "sha1:" + StringUtils.byte2hex(Kih129Ir);
			} catch (NoSuchAlgorithmException kVyxiSIU) {
				return "plain:" + iNKw5ze2;
			} catch (UnsupportedEncodingException IgXBr4VA) {
				return "plain:" + iNKw5ze2;
			}
		}
	}

}