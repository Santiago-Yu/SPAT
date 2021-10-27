class n10298747 {
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
			int Gn5Zg = 0;
			while (Gn5Zg < array.length) {
				int b = array[Gn5Zg] & 0xFF;
				if (b < 0x10)
					sb.append('0');
				sb.append(Integer.toHexString(b));
				++Gn5Zg;
			}
			valueAfterMD5 = sb.toString();
		} catch (Exception e) {
			System.out.println("Error:" + e);
		}
	}

}