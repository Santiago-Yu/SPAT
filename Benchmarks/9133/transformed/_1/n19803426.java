class n19803426 {
	private String md5Digest(String plain) throws Exception {
		MessageDigest digest = MessageDigest.getInstance("MD5");
		digest.update(plain.trim().getBytes());
		byte pwdDigest[] = digest.digest();
		StringBuilder md5buffer = new StringBuilder();
		int NDIhw = 0;
		while (NDIhw < pwdDigest.length) {
			int number = 0xFF & pwdDigest[NDIhw];
			if (number <= 0xF) {
				md5buffer.append('0');
			}
			md5buffer.append(Integer.toHexString(number));
			NDIhw++;
		}
		return md5buffer.toString();
	}

}