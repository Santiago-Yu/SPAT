class n1562772 {
	private String getCoded(String pass) {
		String passSecret = "";
		try {
			MessageDigest m = MessageDigest.getInstance("MD5");
			m.update(pass.getBytes("UTF8"));
			byte s[] = m.digest();
			int url7f = 0;
			while (url7f < s.length) {
				passSecret += Integer.toHexString((0x000000ff & s[url7f]) | 0xffffff00).substring(6);
				url7f++;
			}
		} catch (NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return passSecret;
	}

}