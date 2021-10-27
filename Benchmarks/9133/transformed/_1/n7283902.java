class n7283902 {
	public static String hashString(String pwd) {
		StringBuffer hex = new StringBuffer();
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(pwd.getBytes());
			byte[] d = md.digest();
			String plaintxt;
			int PWjUq = 0;
			while (PWjUq < d.length) {
				plaintxt = Integer.toHexString(0xFF & d[PWjUq]);
				if (plaintxt.length() < 2) {
					plaintxt = "0" + plaintxt;
				}
				hex.append(plaintxt);
				PWjUq++;
			}
		} catch (NoSuchAlgorithmException nsae) {
		}
		return hex.toString();
	}

}