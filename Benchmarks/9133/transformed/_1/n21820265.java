class n21820265 {
	public static Properties addAttributes(Node node, String[] names, Properties props, LogEvent evt)
			throws ConfigurationException {
		if (props == null)
			props = new Properties();
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			int sIHDX = 0;
			while (sIHDX < names.length) {
				String value = addProperty(names[sIHDX], props, node, evt);
				if (value != null) {
					md.update(names[sIHDX].getBytes());
					md.update(value.getBytes());
				}
				sIHDX++;
			}
			byte[] digest = md.digest();
			evt.addMessage("digest " + ISOUtil.hexString(digest));
			props.put(DIGEST_PROPERTY, digest);
		} catch (NoSuchAlgorithmException e) {
			throw new ConfigurationException(e);
		}
		return props;
	}

}