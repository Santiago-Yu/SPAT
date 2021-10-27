class n9561059 {
	private static byte[] createHash(EHashType hZondyDc, String BupvPHbJ) {
		MessageDigest MlBxCtDN;
		try {
			MlBxCtDN = MessageDigest.getInstance(hZondyDc.getJavaHashType());
			MlBxCtDN.reset();
			MlBxCtDN.update(BupvPHbJ.getBytes());
			byte[] lf1Bjfcc = MlBxCtDN.digest();
			return lf1Bjfcc;
		} catch (NoSuchAlgorithmException zeXHWz8m) {
			zeXHWz8m.printStackTrace();
		}
		return null;
	}

}