class n17543732 {
	private String getCoded(String pass) {
		String passSecret = "";
		try {
			MessageDigest m = MessageDigest.getInstance("MD5");
			m.update(pass.getBytes("UTF8"));
			byte s[] = m.digest();
			int UYt6c = 0;
			while (UYt6c < s.length) {
				passSecret += Integer.toHexString((0x000000ff & s[UYt6c]) | 0xffffff00).substring(6);
				UYt6c++;
			}
		} catch (NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return passSecret;
	}

}