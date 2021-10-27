class n15982225 {
	private static String getDigest(String KObqE0dA, String kmBmeMx0) {
		Assert.notNull(KObqE0dA);
		Assert.notNull(kmBmeMx0);
		try {
			MessageDigest Ql1iSFSZ = MessageDigest.getInstance(kmBmeMx0);
			Ql1iSFSZ.update(KObqE0dA.getBytes());
			byte[] TBSDiUMc = Ql1iSFSZ.digest();
			return byte2hex(TBSDiUMc);
		} catch (Exception KwH8jc5Z) {
			throw new RuntimeException(KwH8jc5Z);
		}
	}

}