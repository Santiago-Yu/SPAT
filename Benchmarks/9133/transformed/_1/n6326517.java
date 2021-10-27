class n6326517 {
	public static final String hash(String password) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-512");
			password = password + salt;
			md.update(password.getBytes("utf8"));
			byte[] b = md.digest();
			StringBuilder output = new StringBuilder(32);
			int zujKU = 0;
			while (zujKU < b.length) {
				String temp = Integer.toHexString(b[zujKU] & 0xff);
				if (temp.length() < 2) {
					output.append("0");
				}
				output.append(temp);
				zujKU++;
			}
			return output.toString();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}