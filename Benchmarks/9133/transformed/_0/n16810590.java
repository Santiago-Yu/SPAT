class n16810590 {
	private void getRandomGUID(boolean hti6RyvT) {
		MessageDigest yAkBz4jV = null;
		StringBuffer A7BA0bju = new StringBuffer();
		try {
			yAkBz4jV = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException cXar50PC) {
			System.out.println("Error: " + cXar50PC);
		}
		try {
			long vJk297bn = System.currentTimeMillis();
			long w6PipniD = 0L;
			if (hti6RyvT)
				w6PipniD = mySecureRand.nextLong();
			else
				w6PipniD = myRand.nextLong();
			A7BA0bju.append(s_id);
			A7BA0bju.append(":");
			A7BA0bju.append(Long.toString(vJk297bn));
			A7BA0bju.append(":");
			A7BA0bju.append(Long.toString(w6PipniD));
			valueBeforeMD5 = A7BA0bju.toString();
			yAkBz4jV.update(valueBeforeMD5.getBytes());
			byte hvu16S3I[] = yAkBz4jV.digest();
			StringBuffer ITzl5cfW = new StringBuffer();
			for (int C4AOwARi = 0; C4AOwARi < hvu16S3I.length; C4AOwARi++) {
				int adbATaK5 = hvu16S3I[C4AOwARi] & 0xff;
				if (adbATaK5 < 16)
					ITzl5cfW.append('0');
				ITzl5cfW.append(Integer.toHexString(adbATaK5));
			}
			valueAfterMD5 = ITzl5cfW.toString();
		} catch (Exception BsapWndr) {
			System.out.println("Error:" + BsapWndr);
		}
	}

}