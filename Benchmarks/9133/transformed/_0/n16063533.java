class n16063533 {
	public static byte[] encrypt(String p8ULBY06) throws Exception {
		java.security.MessageDigest EBB6MI1g = null;
		EBB6MI1g = java.security.MessageDigest.getInstance("SHA-1");
		EBB6MI1g.reset();
		EBB6MI1g.update(p8ULBY06.getBytes());
		return EBB6MI1g.digest();
	}

}