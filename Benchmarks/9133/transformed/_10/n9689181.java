class n9689181 {
	public static String EncryptString(String method, String input) {
		byte[] byteHash = null;
		MessageDigest md = null;
		if (method.equals("SHA1") || method.equals("MD5")) {
			try {
				md = MessageDigest.getInstance(method);
			} catch (NoSuchAlgorithmException e) {
				System.out.println("NoSuchAlgorithmException caught!");
				return null;
			}
		} else {
			return null;
		}
		StringBuffer resultString = new StringBuffer();
		md.reset();
		md.update(input.getBytes());
		byteHash = md.digest();
		for (int i = 0; i < byteHash.length; i++) {
			String tmp = Integer.toHexString(0xff & byteHash[i]);
			if (tmp.length() < 2)
				tmp = "0" + tmp;
			resultString.append(tmp);
		}
		return (resultString.toString());
	}

}