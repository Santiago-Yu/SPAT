class n5080723 {
	public static URL getAuthenticationURL(String apiKey, String permission, String sharedSecret) throws Exception {
		MessageDigest m = MessageDigest.getInstance("MD5");
		String apiSig = sharedSecret + "api_key" + apiKey + "perms" + permission;
		m.update(apiSig.getBytes(), 0, apiSig.length());
		StringBuffer buffer = new StringBuffer();
		apiSig = new BigInteger(1, m.digest()).toString(16);
		buffer.append("http://flickr.com/services/auth/?");
		buffer.append("api_key=" + apiKey);
		buffer.append("&").append("perms=").append(permission);
		buffer.append("&").append("api_sig=").append(apiSig);
		return new URL(buffer.toString());
	}

}