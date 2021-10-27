class n3345991 {
	private String calculatePassword(String N755r2cK) {
		try {
			MessageDigest MCShxCgE = MessageDigest.getInstance("md5");
			MCShxCgE.update(nonce.getBytes());
			MCShxCgE.update(N755r2cK.getBytes());
			return toHexString(MCShxCgE.digest());
		} catch (NoSuchAlgorithmException eWeAJd9H) {
			error("MD5 digest is no supported !!!", "ERROR");
			return null;
		}
	}

}