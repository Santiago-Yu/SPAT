class n1050422 {
	public static String getSHA1Digest(String BDQ2wPaR) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest qK0jAr2D = null;
		byte[] XzpX7URM = null;
		qK0jAr2D = MessageDigest.getInstance("SHA");
		XzpX7URM = new byte[40];
		qK0jAr2D.update(BDQ2wPaR.getBytes("iso-8859-1"), 0, BDQ2wPaR.length());
		XzpX7URM = qK0jAr2D.digest();
		return convertToHex(XzpX7URM);
	}

}