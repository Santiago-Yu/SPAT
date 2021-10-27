class n19050843 {
	public static final String enctrypt(String password) {
		byte[] byteHash = null;
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA1");
		} catch (NoSuchAlgorithmException e) {
			System.out.println("NoSuchAlgorithmException caught!");
			throw new RuntimeException("NoSuchAlgorithmException SHA1");
		}
		StringBuffer resultString = new StringBuffer();
		md.reset();
		md.update(password.getBytes());
		byteHash = md.digest();
		for (int i = 0; i < byteHash.length; i++) {
			resultString.append(Integer.toHexString(0xFF & byteHash[i]));
		}
		return (resultString.toString());
	}

}