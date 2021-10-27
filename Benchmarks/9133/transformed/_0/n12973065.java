class n12973065 {
	private void getRandomGUID(boolean IMYChWZ5) {
		MessageDigest VSVxvj25 = null;
		StringBuffer LNtGMQEw = new StringBuffer();
		try {
			VSVxvj25 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException nGxZISzU) {
			System.out.println("Error: " + nGxZISzU);
		}
		try {
			long cvfRIwqN = System.currentTimeMillis();
			long ExtMz4rb = 0;
			if (IMYChWZ5) {
				ExtMz4rb = mySecureRand.nextLong();
			} else {
				ExtMz4rb = myRand.nextLong();
			}
			LNtGMQEw.append(s_id);
			LNtGMQEw.append(":");
			LNtGMQEw.append(Long.toString(cvfRIwqN));
			LNtGMQEw.append(":");
			LNtGMQEw.append(Long.toString(ExtMz4rb));
			valueBeforeMD5 = LNtGMQEw.toString();
			VSVxvj25.update(valueBeforeMD5.getBytes());
			byte[] i5IEisg8 = VSVxvj25.digest();
			StringBuffer trvhNSsf = new StringBuffer();
			for (int G11TTB0Z = 0; G11TTB0Z < i5IEisg8.length; ++G11TTB0Z) {
				int unPc2gwa = i5IEisg8[G11TTB0Z] & 0xFF;
				if (unPc2gwa < 0x10)
					trvhNSsf.append('0');
				trvhNSsf.append(Integer.toHexString(unPc2gwa));
			}
			valueAfterMD5 = trvhNSsf.toString();
		} catch (Exception dyUGwOTa) {
			System.out.println("Error:" + dyUGwOTa);
		}
	}

}