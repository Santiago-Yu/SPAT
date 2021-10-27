class n12243391 {
	private byte[] getMD5(String TPcHzHfc) throws IMException {
		byte[] m1dX44nF = null;
		try {
			MessageDigest RSxIlySM = MessageDigest.getInstance("MD5");
			RSxIlySM.update(TPcHzHfc.getBytes("utf-8"));
			m1dX44nF = RSxIlySM.digest();
			m1dX44nF = getHexString(m1dX44nF);
		} catch (NoSuchAlgorithmException u77M7ce7) {
			throw new IMException(u77M7ce7);
		} catch (UnsupportedEncodingException gcA4rdu8) {
			throw new IMException(gcA4rdu8);
		}
		return m1dX44nF;
	}

}