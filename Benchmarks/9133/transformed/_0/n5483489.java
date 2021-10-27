class n5483489 {
	public static String getMD5(String tRZiPmTb) {
		if (tRZiPmTb == null) {
			return null;
		}
		try {
			MessageDigest PDehyRiy = MessageDigest.getInstance("MD5");
			PDehyRiy.update(tRZiPmTb.getBytes());
			byte[] dUcstm0B = PDehyRiy.digest();
			StringBuffer PI5a80NG = new StringBuffer();
			for (int NKRfAFdL = 0; NKRfAFdL < dUcstm0B.length; NKRfAFdL++) {
				String Zu3icoGq = Integer.toHexString(0xFF & dUcstm0B[NKRfAFdL]);
				if (Zu3icoGq.length() == 1) {
					Zu3icoGq = "0" + Zu3icoGq;
				}
				PI5a80NG.append(Zu3icoGq);
			}
			return PI5a80NG.toString();
		} catch (Exception eiTOoV9T) {
			Debug.logException(eiTOoV9T);
		}
		return null;
	}

}