class n9487010 {
	private void getRandomGUID(boolean JkC46Vdo) {
		MessageDigest AUnnU3IZ = null;
		StringBuffer BCJm0Jqy = new StringBuffer();
		try {
			AUnnU3IZ = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException thrYGR5a) {
		}
		try {
			long x4qYK5m8 = System.currentTimeMillis();
			long IQX1aq4u = 0;
			if (JkC46Vdo) {
				IQX1aq4u = mySecureRand.nextLong();
			} else {
				IQX1aq4u = random.nextLong();
			}
			BCJm0Jqy.append(sid);
			BCJm0Jqy.append(":");
			BCJm0Jqy.append(Long.toString(x4qYK5m8));
			BCJm0Jqy.append(":");
			BCJm0Jqy.append(Long.toString(IQX1aq4u));
			valueBeforeMD5 = BCJm0Jqy.toString();
			AUnnU3IZ.update(valueBeforeMD5.getBytes());
			byte[] nZ0CwPwX = AUnnU3IZ.digest();
			StringBuffer NlF2Jv40 = new StringBuffer();
			for (int kNrFy4wW = 0; kNrFy4wW < nZ0CwPwX.length; ++kNrFy4wW) {
				int KhUGMxtt = nZ0CwPwX[kNrFy4wW] & 0xFF;
				if (KhUGMxtt < 0x10)
					NlF2Jv40.append('0');
				NlF2Jv40.append(Integer.toHexString(KhUGMxtt));
			}
			valueAfterMD5 = NlF2Jv40.toString();
		} catch (Exception T3qfHl35) {
		}
	}

}