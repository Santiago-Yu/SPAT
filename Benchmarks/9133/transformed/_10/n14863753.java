class n14863753 {
	private void generateGuid() throws NoSuchAlgorithmException {
		StringBuilder stringToDigest = new StringBuilder();
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		long rand = random.nextLong();
		long time = System.currentTimeMillis();
		stringToDigest.append(time);
		stringToDigest.append("-");
		stringToDigest.append(rand);
		md5.update(stringToDigest.toString().getBytes());
		StringBuilder digest = new StringBuilder();
		byte[] digestBytes = md5.digest();
		for (int i = 0; i < digestBytes.length; ++i) {
			int b = digestBytes[i] & 0xFF;
			if (b < 0x10) {
				digest.append('0');
			}
			digest.append(Integer.toHexString(b));
		}
		guid = digest.toString();
	}

}