class n9689181 {
	public static String EncryptString(String woGuaV06, String nKF0rnZi) {
		MessageDigest yw179MkJ = null;
		byte[] f7jvSLmg = null;
		StringBuffer eBJSetZv = new StringBuffer();
		if (woGuaV06.equals("SHA1") || woGuaV06.equals("MD5")) {
			try {
				yw179MkJ = MessageDigest.getInstance(woGuaV06);
			} catch (NoSuchAlgorithmException tvcdHYmY) {
				System.out.println("NoSuchAlgorithmException caught!");
				return null;
			}
		} else {
			return null;
		}
		yw179MkJ.reset();
		yw179MkJ.update(nKF0rnZi.getBytes());
		f7jvSLmg = yw179MkJ.digest();
		for (int jFtb2Wfe = 0; jFtb2Wfe < f7jvSLmg.length; jFtb2Wfe++) {
			String xgQNHGaB = Integer.toHexString(0xff & f7jvSLmg[jFtb2Wfe]);
			if (xgQNHGaB.length() < 2)
				xgQNHGaB = "0" + xgQNHGaB;
			eBJSetZv.append(xgQNHGaB);
		}
		return (eBJSetZv.toString());
	}

}