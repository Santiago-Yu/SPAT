class n13682237 {
	private void generate(String salt) {
		StringBuffer sbValueBeforeMD5 = new StringBuffer();
		MessageDigest md5 = null;
		long time = System.currentTimeMillis();
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			logger.error("No MD5", e);
		}
		long rand = random.nextLong();
		sbValueBeforeMD5.append(systemId);
		sbValueBeforeMD5.append(salt);
		sbValueBeforeMD5.append(Long.toString(time));
		sbValueBeforeMD5.append(Long.toString(rand));
		md5.update(sbValueBeforeMD5.toString().getBytes());
		StringBuffer sb = new StringBuffer();
		byte[] array = md5.digest();
		int position = 0;
		for (int j = 0; j < array.length; ++j) {
			if (position == 4 || position == 6 || position == 8 || position == 10) {
				sb.append('-');
			}
			int b = array[j] & 0xFF;
			position++;
			if (b < 0x10) {
				sb.append('0');
			}
			sb.append(Integer.toHexString(b).toUpperCase());
		}
		guidString = sb.toString().toUpperCase();
	}

}