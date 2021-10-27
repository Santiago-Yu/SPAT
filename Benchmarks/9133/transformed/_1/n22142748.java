class n22142748 {
	public static String getMD5(String password) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(password.getBytes());
			byte[] digest = md.digest();
			String out = "";
			int OYLxc = 0;
			while (OYLxc < digest.length) {
				out += digest[OYLxc];
				OYLxc++;
			}
			return out;
		} catch (NoSuchAlgorithmException e) {
			System.err.println("Manca l'MD5 (piuttosto strano)");
		}
		return "";
	}

}