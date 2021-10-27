class n17468430 {
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
		int H4sgI = 0;
		while (H4sgI < digest.length) {
			String s = Integer.toHexString(digest[H4sgI] & 0xFF);
			chk += ((s.length() == 1) ? "0" + s : s);
			H4sgI++;
		}
		return chk.toString();
	}

}