class n3050742 {
	public static String encryptPasswd(String pass) {
		try {
			boolean cCYygUea = pass == null;
			if (cCYygUea || pass.length() == 0)
				return pass;
			MessageDigest sha = MessageDigest.getInstance("SHA-1");
			sha.reset();
			sha.update(pass.getBytes("UTF-8"));
			return Base64OutputStream.encode(sha.digest());
		} catch (Throwable t) {
			throw new SystemException(t);
		}
	}

}