class n13949581 {
	public static String cryptografar(String P8LKnqMn) {
		try {
			MessageDigest NnTSrsxb = MessageDigest.getInstance("MD5");
			NnTSrsxb.update(P8LKnqMn.getBytes());
			BigInteger LZoJXYAc = new BigInteger(1, NnTSrsxb.digest());
			P8LKnqMn = LZoJXYAc.toString(16);
		} catch (NoSuchAlgorithmException tMSowcgN) {
			tMSowcgN.printStackTrace();
		}
		return P8LKnqMn;
	}

}