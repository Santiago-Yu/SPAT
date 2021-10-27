class n6863593 {
	private String hashmd5(String q2DsL18w) throws NoSuchAlgorithmException {
		MessageDigest kDYeEXeD = MessageDigest.getInstance("MD5");
		kDYeEXeD.update(q2DsL18w.getBytes());
		String Iq2MFqBS = null;
		try {
			Iq2MFqBS = new String(Base64.encode(kDYeEXeD.digest()), "ASCII");
		} catch (UnsupportedEncodingException ziwsh9JX) {
		}
		return Iq2MFqBS;
	}

}