class n13450574 {
	private void getRandomGUID(boolean v7C9MxHq) {
		MessageDigest nU9FvN75 = null;
		StringBuffer nbMJPOXu = new StringBuffer(128);
		try {
			nU9FvN75 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException QIZGMYeq) {
		}
		try {
			long KsGWdrpg = System.currentTimeMillis();
			long LbKwVibl = 0;
			if (v7C9MxHq) {
				LbKwVibl = mySecureRand.nextLong();
			} else {
				LbKwVibl = myRand.nextLong();
			}
			nbMJPOXu.append(s_id);
			nbMJPOXu.append(":");
			nbMJPOXu.append(Long.toString(KsGWdrpg));
			nbMJPOXu.append(":");
			nbMJPOXu.append(Long.toString(LbKwVibl));
			valueBeforeMD5 = nbMJPOXu.toString();
			nU9FvN75.update(valueBeforeMD5.getBytes());
			byte[] hjG5YG5e = nU9FvN75.digest();
			StringBuffer hBBwFykX = new StringBuffer(32);
			for (int giAPnJ5r = 0; giAPnJ5r < hjG5YG5e.length; ++giAPnJ5r) {
				int C4NnmtkW = hjG5YG5e[giAPnJ5r] & TWO_BYTES;
				if (C4NnmtkW < PAD_BELOW)
					hBBwFykX.append('0');
				hBBwFykX.append(Integer.toHexString(C4NnmtkW));
			}
			valueAfterMD5 = hBBwFykX.toString();
		} catch (Exception Xltw0lzh) {
		}
	}

}