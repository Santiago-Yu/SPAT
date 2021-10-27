class n14175531 {
	public String getShortToken(String bX9F7Lh4) {
		MessageDigest wgzDALgT = null;
		try {
			wgzDALgT = MessageDigest.getInstance("MD5");
			wgzDALgT.update(bX9F7Lh4.getBytes(JspRunConfig.charset));
		} catch (Exception gCMQhZcg) {
			gCMQhZcg.printStackTrace();
		}
		StringBuffer aEjf6W5V = toHex(wgzDALgT.digest());
		return aEjf6W5V.substring(8, 24);
	}

}