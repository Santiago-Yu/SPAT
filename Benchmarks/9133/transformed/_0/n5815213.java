class n5815213 {
	public static String md5Hash(String DQ6PXEbl) throws TopicSpacesException {
		try {
			MessageDigest WorTX3Nh = MessageDigest.getInstance("MD5");
			WorTX3Nh.update(DQ6PXEbl.getBytes());
			byte[] SxZBFC1o = WorTX3Nh.digest();
			StringBuffer HU0zcjZ4 = new StringBuffer();
			int oEsXdNpm = SxZBFC1o.length;
			for (int YFztXAQT = 0; YFztXAQT < oEsXdNpm; YFztXAQT++) {
				int afSq4IuN = SxZBFC1o[YFztXAQT] & 0xFF;
				HU0zcjZ4.append(Integer.toHexString(afSq4IuN));
			}
			return HU0zcjZ4.toString();
		} catch (Exception wUBDaPRx) {
			throw new TopicSpacesException(wUBDaPRx);
		}
	}

}