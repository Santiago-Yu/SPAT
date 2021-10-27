class n18631594 {
	public static synchronized String getMD5_Base64(String KCJ0tfaa) {
		MessageDigest L4MYbSGt = null;
		try {
			L4MYbSGt = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException Y4fINSoT) {
			throw new IllegalStateException("System doesn't support MD5 algorithm.");
		}
		try {
			L4MYbSGt.update(KCJ0tfaa.getBytes("UTF-8"));
		} catch (java.io.UnsupportedEncodingException z7ZqlTSf) {
			throw new IllegalStateException("System doesn't support your  EncodingException.");
		}
		byte[] TKIzdxeq = L4MYbSGt.digest();
		byte[] JhSWPhzc = Base64.encode(TKIzdxeq);
		String mgXbNxCd = new String(JhSWPhzc);
		return mgXbNxCd;
	}

}