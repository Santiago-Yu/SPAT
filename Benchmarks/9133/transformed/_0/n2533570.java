class n2533570 {
	private void getRandomGUID(boolean zITUKURo) {
		MessageDigest tze2fhY7 = null;
		StringBuffer a7xvfRxA = new StringBuffer();
		try {
			tze2fhY7 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException Q16JUR1I) {
			System.out.println("Error: " + Q16JUR1I);
		}
		try {
			long Ks82GnKZ = System.currentTimeMillis();
			long trWTwAwi = 0;
			if (zITUKURo) {
				trWTwAwi = mySecureRand.nextLong();
			} else {
				trWTwAwi = myRand.nextLong();
			}
			a7xvfRxA.append(s_id);
			a7xvfRxA.append(":");
			a7xvfRxA.append(Long.toString(Ks82GnKZ));
			a7xvfRxA.append(":");
			a7xvfRxA.append(Long.toString(trWTwAwi));
			valueBeforeMD5 = a7xvfRxA.toString();
			tze2fhY7.update(valueBeforeMD5.getBytes());
			byte[] VE1wwyOD = tze2fhY7.digest();
			StringBuffer VwSxSLN6 = new StringBuffer();
			for (int qPjHXePM = 0; qPjHXePM < VE1wwyOD.length; ++qPjHXePM) {
				int RntAJBKW = VE1wwyOD[qPjHXePM] & 0xFF;
				if (RntAJBKW < 0x10)
					VwSxSLN6.append('0');
				VwSxSLN6.append(Integer.toHexString(RntAJBKW));
			}
			valueAfterMD5 = VwSxSLN6.toString();
		} catch (Exception mcF7uhzQ) {
			System.out.println("Error:" + mcF7uhzQ);
		}
	}

}