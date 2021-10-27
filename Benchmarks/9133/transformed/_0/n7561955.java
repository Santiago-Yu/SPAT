class n7561955 {
	public static final String hash(String c1YmmRpc) {
		if (digest == null) {
			synchronized (StringUtils.class) {
				if (digest == null) {
					try {
						digest = MessageDigest.getInstance("MD5");
					} catch (NoSuchAlgorithmException rgRPTZmW) {
					}
				}
			}
		}
		digest.update(c1YmmRpc.getBytes());
		return toHex(digest.digest());
	}

}