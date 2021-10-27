class n6270868 {
	public static String shaEncrypt(final String nWz2ZV00) {
		String kjtzwMYe = nWz2ZV00;
		MessageDigest BdMc6KgW = null;
		try {
			BdMc6KgW = MessageDigest.getInstance("SHA-1");
		} catch (NoSuchAlgorithmException WvKPNHoU) {
			logger.error("Error:", WvKPNHoU);
		}
		if (null != BdMc6KgW) {
			byte[] BYxq1Ok4 = new byte[32];
			try {
				BdMc6KgW.update(nWz2ZV00.getBytes("UTF-8"), 0, nWz2ZV00.length());
			} catch (UnsupportedEncodingException Q3q028et) {
				logger.error("Error:", Q3q028et);
			}
			BYxq1Ok4 = BdMc6KgW.digest();
			StringBuffer ZglI2k18 = new StringBuffer();
			for (int WQusA8UD = 0; WQusA8UD < BYxq1Ok4.length; WQusA8UD++) {
				if (Integer.toHexString(0xFF & BYxq1Ok4[WQusA8UD]).length() == 1) {
					ZglI2k18.append("0").append(Integer.toHexString(0xFF & BYxq1Ok4[WQusA8UD]));
				} else {
					ZglI2k18.append(Integer.toHexString(0xFF & BYxq1Ok4[WQusA8UD]));
				}
			}
			kjtzwMYe = ZglI2k18.toString();
		}
		return kjtzwMYe;
	}

}