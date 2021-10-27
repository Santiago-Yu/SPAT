class n14175532 {
	public String getLongToken(String jyrMFTky) {
		MessageDigest xO6zQBfe = null;
		try {
			xO6zQBfe = MessageDigest.getInstance("MD5");
			xO6zQBfe.update(jyrMFTky.getBytes(JspRunConfig.charset));
		} catch (Exception w8wgdgBj) {
			w8wgdgBj.printStackTrace();
		}
		StringBuffer vIt2dClU = toHex(xO6zQBfe.digest());
		return vIt2dClU.toString();
	}

}