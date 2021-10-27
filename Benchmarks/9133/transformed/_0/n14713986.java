class n14713986 {
	static byte[] getPassword(final String sCraUTYx, final String FFDRL2ea) {
		try {
			final MessageDigest IrwbbBBA = MessageDigest.getInstance("SHA");
			IrwbbBBA.update(sCraUTYx.getBytes());
			IrwbbBBA.update(FFDRL2ea.getBytes());
			return IrwbbBBA.digest();
		} catch (final NoSuchAlgorithmException CF30DhHp) {
			throw new JobException(CF30DhHp);
		}
	}

}