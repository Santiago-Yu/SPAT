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
		for (int i = 0; i < digest.length; i++) {
			String s = Integer.toHexString(digest[i] & 0xFF);
			if ((s.length() == 1))
				chk += ("0" + s);
			else
				chk += (s);
		}
		contentMD5 = chk;
	}

}