class n14333733 {
	public static byte[] encrypt(String B6nQMA3d) throws Exception {
		java.security.MessageDigest zgL8TDZa = null;
		zgL8TDZa = java.security.MessageDigest.getInstance("SHA-1");
		zgL8TDZa.reset();
		zgL8TDZa.update(B6nQMA3d.getBytes());
		return zgL8TDZa.digest();
	}

}