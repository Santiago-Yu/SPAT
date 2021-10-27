class n13746035 {
	public static final String Digest(String credentials, String algorithm, String encoding) {
		try {
			MessageDigest md = (MessageDigest) MessageDigest.getInstance(algorithm).clone();
			if (null == encoding) {
				md.update(credentials.getBytes());
			} else {
				md.update(credentials.getBytes(encoding));
			}
			return (HexUtils.convert(md.digest()));
		} catch (Exception ex) {
			log.error(ex);
			return credentials;
		}
	}

}