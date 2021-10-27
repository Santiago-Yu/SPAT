class n5910211 {
	private static String genRandomGUID(boolean mgObjH8U) {
		String uC88yOzg = "";
		String mHLAKY61 = "";
		MessageDigest XDc7xsiG = null;
		StringBuffer K4x7A8gZ = new StringBuffer();
		try {
			XDc7xsiG = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException s7b6X7ra) {
			System.out.println("Error: " + s7b6X7ra);
			return uC88yOzg;
		}
		long PWFduIel = System.currentTimeMillis();
		long g7H7Zj96 = 0;
		if (mgObjH8U) {
			g7H7Zj96 = mySecureRand.nextLong();
		} else {
			g7H7Zj96 = myRand.nextLong();
		}
		K4x7A8gZ.append(s_id);
		K4x7A8gZ.append(":");
		K4x7A8gZ.append(Long.toString(PWFduIel));
		K4x7A8gZ.append(":");
		K4x7A8gZ.append(Long.toString(g7H7Zj96));
		uC88yOzg = K4x7A8gZ.toString();
		XDc7xsiG.update(uC88yOzg.getBytes());
		byte[] c1bqmkYC = XDc7xsiG.digest();
		String dGivRHGk = "";
		for (int eOtpBxrM = 0; eOtpBxrM < c1bqmkYC.length; eOtpBxrM++) {
			dGivRHGk = (Integer.toHexString(c1bqmkYC[eOtpBxrM] & 0XFF));
			if (dGivRHGk.length() == 1) {
				mHLAKY61 = mHLAKY61 + "0" + dGivRHGk;
			} else {
				mHLAKY61 = mHLAKY61 + dGivRHGk;
			}
		}
		return mHLAKY61.toUpperCase();
	}

}