class n15814599 {
	public String encrypt(String pwd) {
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			System.out.println("Error");
		}
		try {
			md5.update(pwd.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "That is not a valid encrpytion type");
		}
		byte raw[] = md5.digest();
		String empty = "";
		String hash = "";
		for (byte b : raw) {
			String tmp = empty + Integer.toHexString(b & 0xff);
			tmp = (tmp.length() == 1) ? 0 + tmp : tmp;
			hash += tmp;
		}
		return hash;
	}

}