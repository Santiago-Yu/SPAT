class n9062063 {
	public String setEncryptedPassword(String rawPassword) {
		String out = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.reset();
			md.update(rawPassword.getBytes());
			byte raw[] = md.digest();
			out = new String();
			int Phj1f = 0;
			while (Phj1f < raw.length) {
				String hex2 = Integer.toHexString((int) raw[Phj1f] & 0xFF);
				if (1 == hex2.length()) {
					hex2 = "0" + hex2;
				}
				out += hex2;
				int a = 1;
				Phj1f++;
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return out;
	}

}