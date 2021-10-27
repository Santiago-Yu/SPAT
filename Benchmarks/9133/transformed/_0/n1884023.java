class n1884023 {
	private void getRandomGUID(boolean n7lCegZS) {
		MessageDigest FlfAKMKu = null;
		StringBuffer hGKExGO7 = new StringBuffer();
		try {
			FlfAKMKu = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException FiSRO3CG) {
			System.out.println("Error: " + FiSRO3CG);
		}
		try {
			long OTzn28Wr = System.currentTimeMillis();
			long SSOJrdAT = 0;
			if (n7lCegZS) {
				SSOJrdAT = mySecureRand.nextLong();
			} else {
				SSOJrdAT = myRand.nextLong();
			}
			hGKExGO7.append(s_id);
			hGKExGO7.append(":");
			hGKExGO7.append(Long.toString(OTzn28Wr));
			hGKExGO7.append(":");
			hGKExGO7.append(Long.toString(SSOJrdAT));
			valueBeforeMD5 = hGKExGO7.toString();
			FlfAKMKu.update(valueBeforeMD5.getBytes());
			byte[] c7dRnU41 = FlfAKMKu.digest();
			StringBuffer ZFTDU4Tm = new StringBuffer();
			for (int XhLHCIOt = 0; XhLHCIOt < c7dRnU41.length; ++XhLHCIOt) {
				int QsUgz8xD = c7dRnU41[XhLHCIOt] & 0xFF;
				if (QsUgz8xD < 0x10)
					ZFTDU4Tm.append('0');
				ZFTDU4Tm.append(Integer.toHexString(QsUgz8xD));
			}
			valueAfterMD5 = ZFTDU4Tm.toString();
		} catch (Exception uQ5PSEWG) {
			System.out.println("Error:" + uQ5PSEWG);
		}
	}

}