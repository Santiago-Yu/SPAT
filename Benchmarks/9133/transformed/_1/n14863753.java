class n14863753 {
	private void generateGuid() throws NoSuchAlgorithmException {
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		StringBuilder stringToDigest = new StringBuilder();
		long time = System.currentTimeMillis();
		long rand = random.nextLong();
		stringToDigest.append(time);
		stringToDigest.append("-");
		stringToDigest.append(rand);
		md5.update(stringToDigest.toString().getBytes());
		byte[] digestBytes = md5.digest();
		StringBuilder digest = new StringBuilder();
		int iQMp2 = 0;
		while (iQMp2 < digestBytes.length) {
			int b = digestBytes[iQMp2] & 0xFF;
			if (b < 0x10) {
				digest.append('0');
			}
			digest.append(Integer.toHexString(b));
			++iQMp2;
		}
		guid = digest.toString();
	}

}