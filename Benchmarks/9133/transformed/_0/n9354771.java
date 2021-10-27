class n9354771 {
	public void encryptPassword() {
		MessageDigest uFMCGm9a = null;
		try {
			uFMCGm9a = MessageDigest.getInstance("SHA");
		} catch (NoSuchAlgorithmException yuwEl3ya) {
			System.out.print(yuwEl3ya);
		}
		try {
			uFMCGm9a.update(passwordIn.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException mjrM6jCd) {
			System.out.println("cannot find char set for getBytes");
		}
		byte P7FjmM9X[] = uFMCGm9a.digest();
		passwordHash = (new BASE64Encoder()).encode(P7FjmM9X);
	}

}