class n20492749 {
	public synchronized String getEncryptedPassword(String NTDUneAJ, String HD9UrUAH)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest qGTN8GGG = null;
		try {
			qGTN8GGG = MessageDigest.getInstance(HD9UrUAH);
			qGTN8GGG.update(NTDUneAJ.getBytes("UTF-8"));
		} catch (NoSuchAlgorithmException x4K7W5F6) {
			throw x4K7W5F6;
		} catch (UnsupportedEncodingException ftUdRXT9) {
			throw ftUdRXT9;
		}
		return (new BigInteger(1, qGTN8GGG.digest())).toString(16);
	}

}