class n22142748 {
	public static String getMD5(String password) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(password.getBytes());
			String out = "";
			byte[] digest = md.digest();
			for (int i = 0; i < digest.length; i++) {
				out += digest[i];
			}
			return out;
		} catch (NoSuchAlgorithmException e) {
			System.err.println("Manca l'MD5 (piuttosto strano)");
		}
		return "";
	}

}