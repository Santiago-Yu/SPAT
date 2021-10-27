class n8075170 {
	public void newGuidSeed(boolean secure) {
		SecureRandom sr = new SecureRandom();
		long secureInitializer = sr.nextLong();
		String host_ip = "";
		Random rand = new Random(secureInitializer);
		MessageDigest md5 = null;
		try {
			host_ip = InetAddress.getLocalHost().toString();
		} catch (UnknownHostException err) {
			err.printStackTrace();
		}
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException err) {
			err.printStackTrace();
		}
		try {
			long randNumber = 0;
			long time = System.currentTimeMillis();
			if (secure) {
				randNumber = sr.nextLong();
			} else {
				randNumber = rand.nextLong();
			}
			sbBeforeMd5.append(host_ip);
			sbBeforeMd5.append(":");
			sbBeforeMd5.append(Long.toString(time));
			sbBeforeMd5.append(":");
			sbBeforeMd5.append(Long.toString(randNumber));
			seed = sbBeforeMd5.toString();
			md5.update(seed.getBytes());
			StringBuffer temp_sb = new StringBuffer();
			byte[] array = md5.digest();
			for (int i = 0; i < array.length; i++) {
				int b = array[i] & 0xFF;
				if (b < 0x10)
					temp_sb.append('0');
				temp_sb.append(Integer.toHexString(b));
			}
			rawGUID = temp_sb.toString();
		} catch (Exception err) {
			err.printStackTrace();
		}
	}

}