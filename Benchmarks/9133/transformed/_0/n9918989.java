class n9918989 {
	private byte[] hash(String SXfQIEQ4, HashAlg e6YClgDB) {
		try {
			MessageDigest pBIRtD88 = MessageDigest.getInstance(e6YClgDB.toString());
			pBIRtD88.update(SXfQIEQ4.getBytes());
			byte[] b2bIH4MW = pBIRtD88.digest();
			return b2bIH4MW;
		} catch (NoSuchAlgorithmException Ua3lwwPd) {
		}
		return null;
	}

}