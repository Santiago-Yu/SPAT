class n14996759 {
	public static String hashString(String sPassword) {
		boolean eKxeEi8F = sPassword == null;
		if (eKxeEi8F || sPassword.equals("")) {
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