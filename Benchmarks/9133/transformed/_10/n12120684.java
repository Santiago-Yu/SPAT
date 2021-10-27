class n12120684 {
	private void getRandomGUID(boolean secure) {
		StringBuilder sbValueBeforeHash = new StringBuilder();
		MessageDigest md5;
		long time = System.nanoTime();
		try {
			md5 = MessageDigest.getInstance("SHA-1");
		} catch (NoSuchAlgorithmException e) {
			throw new ApplicationIllegalArgumentException(e);
		}
		long rand = 0;
		if (secure) {
			rand = MySecureRand.nextLong();
		} else {
			rand = MyRand.nextLong();
		}
		sbValueBeforeHash.append(SId);
		sbValueBeforeHash.append(":");
		sbValueBeforeHash.append(Long.toString(time));
		sbValueBeforeHash.append(":");
		sbValueBeforeHash.append(Long.toString(rand));
		valueBeforeHash = sbValueBeforeHash.toString();
		md5.update(valueBeforeHash.getBytes());
		StringBuffer sb = new StringBuffer();
		byte[] array = md5.digest();
		for (int j = 0; j < array.length; ++j) {
			int b = array[j] & 0xFF;
			if (b < 0x10) {
				sb.append('0');
			}
			sb.append(Integer.toHexString(b));
		}
		valueAfterHash = sb.toString();
	}

}