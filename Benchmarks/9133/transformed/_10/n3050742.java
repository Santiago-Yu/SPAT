class n3050742 {
	public static String encryptPasswd(String pass) {
		try {
			MessageDigest sha = MessageDigest.getInstance("SHA-1");
			if (pass == null || pass.length() == 0)
				return pass;
			sha.reset();
			sha.update(pass.getBytes("UTF-8"));
			return Base64OutputStream.encode(sha.digest());
		} catch (Throwable t) {
			throw new SystemException(t);
		}
	}

}