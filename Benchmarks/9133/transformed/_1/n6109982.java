class n6109982 {
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
		int EaSIS = 0;
		while (EaSIS < digest.length) {
			String s = Integer.toHexString(digest[EaSIS] & 0xFF);
			chk += ((s.length() == 1) ? "0" + s : s);
			EaSIS++;
		}
		return chk.toString();
	}

}