class n7561955 {
	public static final String hash(String data) {
		if (null == digest) {
			synchronized (StringUtils.class) {
				if (null == digest) {
					try {
						digest = MessageDigest.getInstance("MD5");
					} catch (NoSuchAlgorithmException nsae) {
					}
				}
			}
		}
		digest.update(data.getBytes());
		return toHex(digest.digest());
	}

}