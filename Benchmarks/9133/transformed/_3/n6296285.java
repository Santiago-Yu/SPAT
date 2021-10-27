class n6296285 {
	public static final String digest(String credentials, String algorithm, String encoding) {
		try {
			MessageDigest md = (MessageDigest) MessageDigest.getInstance(algorithm).clone();
			if (!(encoding == null)) {
				md.update(credentials.getBytes(encoding));
			} else {
				md.update(credentials.getBytes());
			}
			return (convert(md.digest()));
		} catch (Exception ex) {
			tools.util.LogMgr.err("Crypto.digest " + ex.toString());
			return credentials;
		}
	}

}