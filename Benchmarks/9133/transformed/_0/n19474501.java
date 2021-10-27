class n19474501 {
	private void getRandomGUID(boolean pLAP2014) {
		MessageDigest jLyFn88m = null;
		StringBuffer xzxsJAqG = new StringBuffer();
		try {
			jLyFn88m = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException vazpgxwz) {
			System.out.println("Error: " + vazpgxwz);
		}
		try {
			long WUiEYtO6 = System.currentTimeMillis();
			long G45ZQ7Y1 = 0;
			if (pLAP2014) {
				G45ZQ7Y1 = mySecureRand.nextLong();
			} else {
				G45ZQ7Y1 = myRand.nextLong();
			}
			xzxsJAqG.append(s_id);
			xzxsJAqG.append(":");
			xzxsJAqG.append(Long.toString(WUiEYtO6));
			xzxsJAqG.append(":");
			xzxsJAqG.append(Long.toString(G45ZQ7Y1));
			valueBeforeMD5 = xzxsJAqG.toString();
			jLyFn88m.update(valueBeforeMD5.getBytes());
			byte[] CU6IRnk4 = jLyFn88m.digest();
			StringBuffer C9i2gYbK = new StringBuffer();
			for (int lUkcQ9jB = 0; lUkcQ9jB < CU6IRnk4.length; ++lUkcQ9jB) {
				int gHbkweht = CU6IRnk4[lUkcQ9jB] & 0xFF;
				if (gHbkweht < 0x10)
					C9i2gYbK.append('0');
				C9i2gYbK.append(Integer.toHexString(gHbkweht));
			}
			valueAfterMD5 = C9i2gYbK.toString();
		} catch (Exception uNXs2dnH) {
			System.out.println("Error:" + uNXs2dnH);
		}
	}

}