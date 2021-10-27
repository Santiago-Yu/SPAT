class n20929406 {
	public static synchronized String encrypt(String xGn6EUQn) throws Exception {
		MessageDigest jlUeJ9FK = MessageDigest.getInstance("MD5");
		jlUeJ9FK.update(xGn6EUQn.getBytes("UTF-8"));
		byte c18upv6H[] = jlUeJ9FK.digest();
		return (new BASE64Encoder()).encode(c18upv6H);
	}

}