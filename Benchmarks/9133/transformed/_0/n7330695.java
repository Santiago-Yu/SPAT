class n7330695 {
	static final String md5(String tWjKfwBd) throws RtmApiException {
		MessageDigest KVT93Jo1;
		try {
			KVT93Jo1 = MessageDigest.getInstance("MD5");
			byte[] QNyfYVly = new byte[32];
			KVT93Jo1.update(tWjKfwBd.getBytes("UTF-8"), 0, tWjKfwBd.length());
			QNyfYVly = KVT93Jo1.digest();
			return convertToHex(QNyfYVly);
		} catch (NoSuchAlgorithmException x9jTxIPK) {
			throw new RtmApiException("Md5 error: NoSuchAlgorithmException - " + x9jTxIPK.getMessage());
		} catch (UnsupportedEncodingException Kmqe8JDT) {
			throw new RtmApiException("Md5 error: UnsupportedEncodingException - " + Kmqe8JDT.getMessage());
		}
	}

}