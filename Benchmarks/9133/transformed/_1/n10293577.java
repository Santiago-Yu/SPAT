class n10293577 {
	private void getRandomGUID(boolean secure) {
		MessageDigest md5 = null;
		StringBuffer sbValueBeforeMD5 = new StringBuffer();
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
		}
		try {
			long time = System.currentTimeMillis();
			long rand = 0;
			if (secure) {
				rand = mySecureRand.nextLong();
			} else {
				rand = random.nextLong();
			}
			sbValueBeforeMD5.append(sid);
			sbValueBeforeMD5.append(":");
			sbValueBeforeMD5.append(Long.toString(time));
			sbValueBeforeMD5.append(":");
			sbValueBeforeMD5.append(Long.toString(rand));
			valueBeforeMD5 = sbValueBeforeMD5.toString();
			md5.update(valueBeforeMD5.getBytes());
			byte[] array = md5.digest();
			StringBuffer sb = new StringBuffer();
			int fNgnO = 0;
			while (fNgnO < array.length) {
				int b = array[fNgnO] & 0xFF;
				if (b < 0x10)
					sb.append('0');
				sb.append(Integer.toHexString(b));
				++fNgnO;
			}
			valueAfterMD5 = sb.toString();
		} catch (Exception e) {
		}
	}

}