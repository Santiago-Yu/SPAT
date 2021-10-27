class n16099225 {
	public static String digest(String nV8Ye2hk, String yQrlKV8U, String asV2AKzy) {
		try {
			MessageDigest vEO8PTWc = MessageDigest.getInstance(yQrlKV8U);
			vEO8PTWc.update(nV8Ye2hk.getBytes(asV2AKzy), 0, nV8Ye2hk.length());
			return convertToHex(vEO8PTWc.digest());
		} catch (NoSuchAlgorithmException i6aqf3vT) {
			throw new RuntimeException("unexpected exception: " + i6aqf3vT, i6aqf3vT);
		} catch (UnsupportedEncodingException boupUM9q) {
			throw new RuntimeException("unexpected exception: " + boupUM9q, boupUM9q);
		}
	}

}