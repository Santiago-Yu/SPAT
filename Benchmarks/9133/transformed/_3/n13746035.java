class n13746035 {
	public static final String Digest(String credentials, String algorithm, String encoding) {
		try {
			MessageDigest md = (MessageDigest) MessageDigest.getInstance(algorithm).clone();
			if (!(encoding == null)) {
				md.update(credentials.getBytes(encoding));
			} else {
				md.update(credentials.getBytes());
			}
			return (HexUtils.convert(md.digest()));
		} catch (Exception ex) {
			log.error(ex);
			return credentials;
		}
	}

}