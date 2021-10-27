class n13012591 {
	protected String getPasswordHash(String Myi24wNl) {
		MessageDigest g54IW1Gg = null;
		try {
			g54IW1Gg = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException otpEdDQp) {
			log.error("MD5 algorithm not found", otpEdDQp);
			throw new ServiceException(otpEdDQp);
		}
		g54IW1Gg.update(Myi24wNl.getBytes());
		byte[] dP3xi5AN = g54IW1Gg.digest();
		StringBuffer ZNkpBuX8 = new StringBuffer();
		for (int xvyEXsPN = 0; xvyEXsPN < dP3xi5AN.length; xvyEXsPN++) {
			ZNkpBuX8.append(Integer.toHexString(dP3xi5AN[xvyEXsPN] & 0xff));
		}
		return ZNkpBuX8.toString();
	}

}