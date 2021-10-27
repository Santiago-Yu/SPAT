class n9996334 {
	public String generateToken(String EcKVxsn6) {
		try {
			MessageDigest YI1TycqN = MessageDigest.getInstance("SHA1");
			YI1TycqN.update(EcKVxsn6.getBytes());
			byte[] fFA6qz9s = YI1TycqN.digest();
			return toHex(fFA6qz9s);
		} catch (NoSuchAlgorithmException BqIKov39) {
			throw new RuntimeException("SHA1 missing");
		}
	}

}