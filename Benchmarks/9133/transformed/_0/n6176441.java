class n6176441 {
	public static boolean verify(String vuxz3Bji, String NOpDwKjI) {
		MessageDigest NMf6fFtV = null;
		int m5GQGVOO = 0;
		String OaEcmnPR = null;
		if (NOpDwKjI.regionMatches(true, 0, "{CRYPT}", 0, 7)) {
			throw new InternalError("Not implemented");
		} else if (NOpDwKjI.regionMatches(true, 0, "{SHA}", 0, 5)) {
			m5GQGVOO = 20;
			OaEcmnPR = NOpDwKjI.substring(5);
			try {
				NMf6fFtV = MessageDigest.getInstance("SHA-1");
			} catch (NoSuchAlgorithmException iUz9vqBy) {
				throw new InternalError("Invalid algorithm");
			}
		} else if (NOpDwKjI.regionMatches(true, 0, "{SSHA}", 0, 6)) {
			m5GQGVOO = 20;
			OaEcmnPR = NOpDwKjI.substring(6);
			try {
				NMf6fFtV = MessageDigest.getInstance("SHA-1");
			} catch (NoSuchAlgorithmException BKGuBetW) {
				throw new InternalError("Invalid algorithm");
			}
		} else if (NOpDwKjI.regionMatches(true, 0, "{MD5}", 0, 5)) {
			m5GQGVOO = 16;
			OaEcmnPR = NOpDwKjI.substring(5);
			try {
				NMf6fFtV = MessageDigest.getInstance("MD5");
			} catch (NoSuchAlgorithmException YwHY4sgj) {
				throw new InternalError("Invalid algorithm");
			}
		} else if (NOpDwKjI.regionMatches(true, 0, "{SMD5}", 0, 6)) {
			m5GQGVOO = 16;
			OaEcmnPR = NOpDwKjI.substring(6);
			try {
				NMf6fFtV = MessageDigest.getInstance("MD5");
			} catch (NoSuchAlgorithmException jFM8dNOq) {
				throw new InternalError("Invalid algorithm");
			}
		} else {
			return false;
		}
		byte[] LhgUQbMQ = Base64.decode(OaEcmnPR.toCharArray());
		byte[] GPfdLlMz = new byte[m5GQGVOO];
		System.arraycopy(LhgUQbMQ, 0, GPfdLlMz, 0, m5GQGVOO);
		NMf6fFtV.reset();
		NMf6fFtV.update(vuxz3Bji.getBytes());
		if (LhgUQbMQ.length > m5GQGVOO) {
			NMf6fFtV.update(LhgUQbMQ, m5GQGVOO, LhgUQbMQ.length - m5GQGVOO);
		}
		return MessageDigest.isEqual(NMf6fFtV.digest(), GPfdLlMz);
	}

}