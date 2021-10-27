class n13901037 {
	public static String generateGuid(boolean secure) {
		String valueBeforeMD5 = null;
		MessageDigest md5 = null;
		StringBuffer sbValueBeforeMD5 = new StringBuffer();
		String valueAfterMD5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			log.error("Error: " + e);
		}
		try {
			long rand = 0L;
			long time = System.currentTimeMillis();
			if (secure)
				rand = mySecureRand.nextLong();
			else
				rand = myRand.nextLong();
			sbValueBeforeMD5.append(s_id);
			sbValueBeforeMD5.append(":");
			sbValueBeforeMD5.append(Long.toString(time));
			sbValueBeforeMD5.append(":");
			sbValueBeforeMD5.append(Long.toString(rand));
			valueBeforeMD5 = sbValueBeforeMD5.toString();
			md5.update(valueBeforeMD5.getBytes());
			StringBuffer sb = new StringBuffer();
			byte array[] = md5.digest();
			for (int j = 0; j < array.length; j++) {
				int b = array[j] & 0xff;
				if (b < 16)
					sb.append('0');
				sb.append(Integer.toHexString(b));
			}
			valueAfterMD5 = sb.toString();
		} catch (Exception e) {
			log.error("Error:" + e);
		}
		StringBuffer sb = new StringBuffer();
		String raw = valueAfterMD5.toUpperCase();
		sb.append(raw.substring(0, 8));
		sb.append("-");
		sb.append(raw.substring(8, 12));
		sb.append("-");
		sb.append(raw.substring(12, 16));
		sb.append("-");
		sb.append(raw.substring(16, 20));
		sb.append("-");
		sb.append(raw.substring(20));
		return sb.toString();
	}

}