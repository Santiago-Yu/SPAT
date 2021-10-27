class n10852631 {
	private void getRandomGUID(boolean secure) {
		final StringBuilder sbValueBeforeMD5 = new StringBuilder();
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			logger.fatal("", e);
			return;
		}
		try {
			long rand = 0;
			final long time = System.currentTimeMillis();
			if (secure) {
				rand = mySecureRand.nextLong();
			} else {
				rand = myRand.nextLong();
			}
			sbValueBeforeMD5.append(sId);
			sbValueBeforeMD5.append(":");
			sbValueBeforeMD5.append(Long.toString(time));
			sbValueBeforeMD5.append(":");
			sbValueBeforeMD5.append(Long.toString(rand));
			valueBeforeMD5 = sbValueBeforeMD5.toString();
			md5.update(valueBeforeMD5.getBytes());
			final StringBuilder sb = new StringBuilder();
			final byte[] array = md5.digest();
			for (int j = 0; j < array.length; ++j) {
				final int b = array[j] & 0xFF;
				if (b < 0x10) {
					sb.append('0');
				}
				sb.append(Integer.toHexString(b));
			}
			valueAfterMD5 = sb.toString();
		} catch (Exception e) {
			logger.fatal("", e);
		}
	}

}