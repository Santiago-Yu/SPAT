class n14996759 {
	public static String hashString(String sPassword) {
		if (null == sPassword || sPassword.equals("")) {
			return "empty:";
		} else {
			try {
				MessageDigest md = MessageDigest.getInstance("SHA-1");
				md.update(sPassword.getBytes("UTF-8"));
				byte[] res = md.digest();
				return "sha1:" + StringUtils.byte2hex(res);
			} catch (NoSuchAlgorithmException e) {
				return "plain:" + sPassword;
			} catch (UnsupportedEncodingException e) {
				return "plain:" + sPassword;
			}
		}
	}

}