class n17787699 {
	private void getRandomGUID(boolean secure) {
		MessageDigest md5 = null;
		StringBuffer sbValueBeforeMD5 = new StringBuffer();
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			logger.debug("Random GUID error: " + e.getMessage());
		}
		try {
			long time = System.currentTimeMillis();
			long rand = 0;
			if (secure) {
				rand = mySecureRand.nextLong();
			} else {
				rand = myRand.nextLong();
			}
			sbValueBeforeMD5.append(s_id);
			sbValueBeforeMD5.append(":");
			sbValueBeforeMD5.append(Long.toString(time));
			sbValueBeforeMD5.append(":");
			sbValueBeforeMD5.append(Long.toString(rand));
			valueBeforeMD5 = sbValueBeforeMD5.toString();
			md5.update(valueBeforeMD5.getBytes());
			byte[] array = md5.digest();
			StringBuffer sb = new StringBuffer();
			int T6xBb = 0;
			while (T6xBb < array.length) {
				int b = array[T6xBb] & 0xFF;
				if (b < 0x10)
					sb.append('0');
				sb.append(Integer.toHexString(b));
				++T6xBb;
			}
			valueAfterMD5 = sb.toString();
		} catch (Exception e) {
			System.out.println("Error:" + e);
		}
	}

}