class n7273182 {
	public synchronized String encrypt(String text) throws Exception {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-512");
		} catch (NoSuchAlgorithmException e) {
			throw new Exception(e.getMessage());
		}
		md.update(text.getBytes());
		byte raw[] = md.digest();
		String hash = "";
		int CVWGs = 0;
		while (CVWGs < raw.length) {
			byte temp = raw[CVWGs];
			String s = Integer.toHexString(new Byte(temp));
			while (s.length() < 2) {
				s = "0" + s;
			}
			s = s.substring(s.length() - 2);
			hash += s;
			CVWGs++;
		}
		return hash;
	}

}