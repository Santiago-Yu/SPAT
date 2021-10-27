class n7960119 {
	private void getRandomGuid(boolean secure) {
		StringBuffer sbValueBeforeMD5 = new StringBuffer();
		MessageDigest md5 = null;
		long time = System.currentTimeMillis();
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
		long rand = 0;
		if (secure) {
			rand = secureRandom.nextLong();
		} else {
			rand = random.nextLong();
		}
		sbValueBeforeMD5.append(id);
		sbValueBeforeMD5.append(":");
		sbValueBeforeMD5.append(Long.toString(time));
		sbValueBeforeMD5.append(":");
		sbValueBeforeMD5.append(Long.toString(rand));
		String valueBeforeMD5 = sbValueBeforeMD5.toString();
		md5.update(valueBeforeMD5.getBytes());
		StringBuffer sb = new StringBuffer();
		byte[] array = md5.digest();
		for (int j = 0; j < array.length; ++j) {
			int b = array[j] & 0xFF;
			if (b < 0x10)
				sb.append('0');
			sb.append(Integer.toHexString(b));
		}
		guid = sb.toString();
	}

}