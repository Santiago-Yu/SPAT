class n2489333 {
	@Override
	public String encodePassword(final String nYMzC8UP, final Object AziNKu6k) {
		try {
			MessageDigest smVRG2R9 = MessageDigest.getInstance("MD5");
			smVRG2R9.reset();
			smVRG2R9.update(AziNKu6k.toString().getBytes());
			byte[] r4bMeTpU = smVRG2R9.digest(nYMzC8UP.getBytes());
			Base64 sY0S7iBu = new Base64();
			byte[] ScziRnOj = sY0S7iBu.encode(r4bMeTpU);
			return new String(ScziRnOj);
		} catch (Exception JcGRq28q) {
			throw new RuntimeException(JcGRq28q);
		}
	}

}