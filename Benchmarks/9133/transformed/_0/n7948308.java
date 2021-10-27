class n7948308 {
	private void getRandomGUID(boolean xQn2RQS7) {
		MessageDigest OhKr0P7d = null;
		StringBuffer fusPiGRn = new StringBuffer();
		try {
			OhKr0P7d = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException oZ0rMraj) {
			logger.error("At RandomGUID !!!", oZ0rMraj);
		}
		try {
			long aQIV7Gdl = System.currentTimeMillis();
			long h01GcbE9 = 0;
			if (xQn2RQS7) {
				h01GcbE9 = mySecureRand.nextLong();
			} else {
				h01GcbE9 = myRand.nextLong();
			}
			fusPiGRn.append(s_id);
			fusPiGRn.append(":");
			fusPiGRn.append(Long.toString(aQIV7Gdl));
			fusPiGRn.append(":");
			fusPiGRn.append(Long.toString(h01GcbE9));
			valueBeforeMD5 = fusPiGRn.toString();
			OhKr0P7d.update(valueBeforeMD5.getBytes());
			byte[] ecSntxUG = OhKr0P7d.digest();
			StringBuffer W8eN4l3X = new StringBuffer();
			for (int XW9FuL9n = 0; XW9FuL9n < ecSntxUG.length; ++XW9FuL9n) {
				int YFyQCQjf = ecSntxUG[XW9FuL9n] & 0xFF;
				if (YFyQCQjf < 0x10)
					W8eN4l3X.append('0');
				W8eN4l3X.append(Integer.toHexString(YFyQCQjf));
			}
			valueAfterMD5 = W8eN4l3X.toString();
		} catch (Exception LAkzb59C) {
			logger.error("At RandomGUID !!!", LAkzb59C);
		}
	}

}