class n6109982 {
	private String mkSid() {
		MessageDigest messagedigest = null;
		String temp = toString();
		try {
			messagedigest = MessageDigest.getInstance("SHA");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
		messagedigest.update(temp.getBytes());
		String chk = "";
		byte digest[] = messagedigest.digest();
		for (int i = 0; i < digest.length; i++) {
			String s = Integer.toHexString(digest[i] & 0xFF);
			chk += ((s.length() == 1) ? "0" + s : s);
		}
		return chk.toString();
	}

}