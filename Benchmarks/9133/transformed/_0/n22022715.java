class n22022715 {
	protected static final byte[] digest(String nWm286fe) {
		byte[] AaXySWEs = null;
		try {
			MessageDigest r3gtyCXY = MessageDigest.getInstance("MD5");
			r3gtyCXY.update(nWm286fe.getBytes());
			AaXySWEs = r3gtyCXY.digest();
		} catch (NoSuchAlgorithmException zZxNnyno) {
			System.err.println("no message digest algorithm available!");
			System.exit(1);
		}
		return AaXySWEs;
	}

}