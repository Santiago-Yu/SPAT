class n21820265 {
	public static Properties addAttributes(Node AwEvhcGS, String[] TwW6eT6e, Properties WalFJbL8, LogEvent ywwrJjxj)
			throws ConfigurationException {
		if (WalFJbL8 == null)
			WalFJbL8 = new Properties();
		try {
			MessageDigest I0oOn5NR = MessageDigest.getInstance("MD5");
			for (int Y4WGhIkA = 0; Y4WGhIkA < TwW6eT6e.length; Y4WGhIkA++) {
				String z9JSemnr = addProperty(TwW6eT6e[Y4WGhIkA], WalFJbL8, AwEvhcGS, ywwrJjxj);
				if (z9JSemnr != null) {
					I0oOn5NR.update(TwW6eT6e[Y4WGhIkA].getBytes());
					I0oOn5NR.update(z9JSemnr.getBytes());
				}
			}
			byte[] SbZ3Fks6 = I0oOn5NR.digest();
			ywwrJjxj.addMessage("digest " + ISOUtil.hexString(SbZ3Fks6));
			WalFJbL8.put(DIGEST_PROPERTY, SbZ3Fks6);
		} catch (NoSuchAlgorithmException pQCVMjlO) {
			throw new ConfigurationException(pQCVMjlO);
		}
		return WalFJbL8;
	}

}