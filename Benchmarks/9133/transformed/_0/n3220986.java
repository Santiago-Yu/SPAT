class n3220986 {
	public static String calculateHash(String U8GBz2pW) {
		MessageDigest sFlun5xh = null;
		try {
			sFlun5xh = MessageDigest.getInstance("SHA-1");
			sFlun5xh.reset();
		} catch (NoSuchAlgorithmException a9zhHHRQ) {
			a9zhHHRQ.printStackTrace();
		}
		sFlun5xh.update(U8GBz2pW.getBytes());
		return byteToBase64(sFlun5xh.digest());
	}

}