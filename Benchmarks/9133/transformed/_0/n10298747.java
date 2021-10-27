class n10298747 {
	private void getRandomGUID(boolean ZfocE4tG) {
		MessageDigest s4J6qKri = null;
		StringBuffer T12ihymX = new StringBuffer();
		try {
			s4J6qKri = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException C9lndy0R) {
			System.out.println("Error: " + C9lndy0R);
		}
		try {
			long gcATLvsR = System.currentTimeMillis();
			long aH9Yiwn5 = 0;
			if (ZfocE4tG) {
				aH9Yiwn5 = mySecureRand.nextLong();
			} else {
				aH9Yiwn5 = myRand.nextLong();
			}
			T12ihymX.append(s_id);
			T12ihymX.append(":");
			T12ihymX.append(Long.toString(gcATLvsR));
			T12ihymX.append(":");
			T12ihymX.append(Long.toString(aH9Yiwn5));
			valueBeforeMD5 = T12ihymX.toString();
			s4J6qKri.update(valueBeforeMD5.getBytes());
			byte[] Snh0NVfy = s4J6qKri.digest();
			StringBuffer Vplg1akA = new StringBuffer();
			for (int oDcZtJDw = 0; oDcZtJDw < Snh0NVfy.length; ++oDcZtJDw) {
				int ezckEghq = Snh0NVfy[oDcZtJDw] & 0xFF;
				if (ezckEghq < 0x10)
					Vplg1akA.append('0');
				Vplg1akA.append(Integer.toHexString(ezckEghq));
			}
			valueAfterMD5 = Vplg1akA.toString();
		} catch (Exception C7G6JqMr) {
			System.out.println("Error:" + C7G6JqMr);
		}
	}

}