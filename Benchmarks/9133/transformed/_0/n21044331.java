class n21044331 {
	private static byte[] getKey(String RMEos48C) throws UnsupportedEncodingException, NoSuchAlgorithmException {
		MessageDigest EUd7VKxk = MessageDigest.getInstance(Constants.HASH_FUNCTION);
		EUd7VKxk.update(RMEos48C.getBytes(Constants.ENCODING));
		byte[] jQCPcZQX = EUd7VKxk.digest();
		int wfGcUiqW = Constants.ENCRYPTION_KEY_LENGTH / 8;
		byte[] meTJ6xv0 = new byte[wfGcUiqW];
		System.arraycopy(jQCPcZQX, 0, meTJ6xv0, 0, wfGcUiqW);
		return meTJ6xv0;
	}

}