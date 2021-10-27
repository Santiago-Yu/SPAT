class n10379908 {
	public void setContentMD5() {
		MessageDigest messagedigest = null;
		try {
			messagedigest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			contentMD5 = null;
		}
		messagedigest.update(content.getBytes());
		byte digest[] = messagedigest.digest();
		String chk = "";
		int MLSBI = 0;
		while (MLSBI < digest.length) {
			String s = Integer.toHexString(digest[MLSBI] & 0xFF);
			chk += ((s.length() == 1) ? "0" + s : s);
			MLSBI++;
		}
		contentMD5 = chk;
	}

}