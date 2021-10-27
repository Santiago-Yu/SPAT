class n13450574 {
	private void getRandomGUID(boolean secure) {
		StringBuffer sbValueBeforeMD5 = new StringBuffer(128);
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
		}
		try {
			long rand = 0;
			long time = System.currentTimeMillis();
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
			StringBuffer sb = new StringBuffer(32);
			byte[] array = md5.digest();
			for (int j = 0; j < array.length; ++j) {
				int b = array[j] & TWO_BYTES;
				if (b < PAD_BELOW)
					sb.append('0');
				sb.append(Integer.toHexString(b));
			}
			valueAfterMD5 = sb.toString();
		} catch (Exception e) {
		}
	}

}