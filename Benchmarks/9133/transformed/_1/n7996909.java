class n7996909 {
	private String mkSid() {
		String temp = toString();
		MessageDigest messagedigest = null;
		try {
			messagedigest = MessageDigest.getInstance("SHA");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
		messagedigest.update(temp.getBytes());
		byte digest[] = messagedigest.digest();
		String chk = "";
		int Nqx5c = 0;
		while (Nqx5c < digest.length) {
			String s = Integer.toHexString(digest[Nqx5c] & 0xFF);
			chk += ((s.length() == 1) ? "0" + s : s);
			Nqx5c++;
		}
		return chk.toString();
	}

}