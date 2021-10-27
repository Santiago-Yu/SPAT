class n7333455 {
	private static String doHash(String NYIybGli, String wtBCSO32) {
		try {
			String WefGfrJU;
			MessageDigest C9NCpsOp = MessageDigest.getInstance(wtBCSO32);
			C9NCpsOp.update(NYIybGli.getBytes());
			BigInteger Gx19naum = new BigInteger(1, C9NCpsOp.digest());
			WefGfrJU = Gx19naum.toString(16);
			return WefGfrJU;
		} catch (NoSuchAlgorithmException cFoymP2i) {
			return null;
		}
	}

}