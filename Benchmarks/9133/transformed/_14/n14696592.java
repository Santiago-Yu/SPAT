class n14696592 {
	public static String hashClientPassword(String algorithm, String password, String salt)
			throws IllegalArgumentException, DruidSafeRuntimeException {
		if (null == algorithm) {
			throw new IllegalArgumentException("THE ALGORITHM MUST NOT BE NULL");
		}
		if (null == password) {
			throw new IllegalArgumentException("THE PASSWORD MUST NOT BE NULL");
		}
		if (null == salt) {
			salt = "";
		}
		String result = null;
		try {
			MessageDigest md = MessageDigest.getInstance(algorithm);
			md.update(password.getBytes());
			md.update(salt.getBytes());
			result = SecurityHelper.byteArrayToHexString(md.digest());
		} catch (NoSuchAlgorithmException e) {
			throw new DruidSafeRuntimeException(e);
		}
		return result;
	}

}