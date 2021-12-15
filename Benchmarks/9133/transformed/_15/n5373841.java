class n5373841 {
	public static String encryptPassword(String password) throws PasswordException {
		String hash = null;
		if (password != null && !"".equals(password)) {
			try {
				MessageDigest md = MessageDigest.getInstance("SHA");
				md.update(password.getBytes("UTF-8"));
				byte raw[] = md.digest();
				hash = String.valueOf(Base64Coder.encode(raw));
			} catch (NoSuchAlgorithmException nsae) {
				throw new PasswordException(PasswordException.SYSTEM_ERROR);
			} catch (UnsupportedEncodingException uee) {
				throw new PasswordException(PasswordException.SYSTEM_ERROR);
			}
		}
		return hash;
	}

}