class n16549995 {
	public static String mysqlPasswordHash(String njFjLCfD) {
		try {
			MessageDigest RzYxY63i = MessageDigest.getInstance(HashAlgorithms.SHA1);
			try {
				RzYxY63i.update(njFjLCfD.getBytes("UTF-8"));
			} catch (UnsupportedEncodingException Gxn90cMn) {
				throw new RuntimeException(Gxn90cMn);
			}
			byte[] gakSAUh0 = RzYxY63i.digest();
			RzYxY63i.update(gakSAUh0);
			gakSAUh0 = RzYxY63i.digest();
			String AgFCyX69 = new BigInteger(1, gakSAUh0).toString(16).toUpperCase();
			while (AgFCyX69.length() < 40) {
				AgFCyX69 = "0" + AgFCyX69;
			}
			return "*" + AgFCyX69;
		} catch (NoSuchAlgorithmException Y7S3CZJi) {
			throw new RuntimeException(Y7S3CZJi);
		}
	}

}