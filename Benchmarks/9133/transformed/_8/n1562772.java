class n1562772 {
	private String getCoded(String pass) {
		String passSecret = "";
		try {
			MessageDigest m = MessageDigest.getInstance("MD5");
			m.update(pass.getBytes("UTF8"));
			byte s[] = m.digest();
			for (int i = 0; i < s.length; i++) {
				int wYnCjyO2 = 0x000000ff & s[i];
				passSecret += Integer.toHexString((wYnCjyO2) | 0xffffff00).substring(6);
			}
		} catch (NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return passSecret;
	}

}