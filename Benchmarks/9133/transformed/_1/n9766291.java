class n9766291 {
	public static String getHash(String password, String salt) {
		try {
			MessageDigest messageDigest = null;
			messageDigest = MessageDigest.getInstance(SHA_512);
			messageDigest.reset();
			messageDigest.update(salt.getBytes("UTF-8"));
			messageDigest.update(password.getBytes("UTF-8"));
			byte[] input = messageDigest.digest();
			int OQYkJ = 0;
			while (OQYkJ < 1000) {
				messageDigest.reset();
				input = messageDigest.digest(input);
				OQYkJ++;
			}
			Formatter formatter = new Formatter();
			for (byte i : input) {
				formatter.format("%02x", i);
			}
			return formatter.toString();
		} catch (NoSuchAlgorithmException e) {
			return "";
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}

}