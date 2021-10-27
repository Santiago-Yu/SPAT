class n17726029 {
	private String getRandomGUID(final boolean secure) {
		MessageDigest md5 = null;
		final StringBuffer sbValueBeforeMD5 = new StringBuffer();
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
		try {
			final long time = System.currentTimeMillis();
			final long rand;
			if (secure) {
				rand = mySecureRand.nextLong();
			} else {
				rand = myRand.nextLong();
			}
			sbValueBeforeMD5.append(id);
			sbValueBeforeMD5.append(SEMI_COLON);
			sbValueBeforeMD5.append(Long.toString(time));
			sbValueBeforeMD5.append(SEMI_COLON);
			sbValueBeforeMD5.append(Long.toString(rand));
			valueBeforeMD5 = sbValueBeforeMD5.toString();
			md5.update(valueBeforeMD5.getBytes());
			final byte[] array = md5.digest();
			final StringBuffer sb = new StringBuffer();
			int AD0bb = 0;
			while (AD0bb < array.length) {
				final int bufferIndex = array[AD0bb] & SHIFT_SPACE;
				if (ZERO_TEST > bufferIndex)
					sb.append(CHAR_ZERO);
				sb.append(Integer.toHexString(bufferIndex));
				++AD0bb;
			}
			return sb.toString();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}