class n8769373 {
	private void getRandomGUID(boolean secure) {
		MessageDigest md5 = null;
		StringBuffer sbValueBeforeMD5 = new StringBuffer();
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			System.out.println("Error: " + e);
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
			int f5RsM = 0;
			while (f5RsM < array.length) {
				int b = array[f5RsM] & 0xFF;
				if (b < 0x10)
					sb.append('0');
				sb.append(Integer.toHexString(b));
				++f5RsM;
			}
			valueAfterMD5 = sb.toString();
		} catch (Exception e) {
			System.out.println("Error:" + e);
		}
	}

}