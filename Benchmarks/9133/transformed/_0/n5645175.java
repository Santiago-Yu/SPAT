class n5645175 {
	private String generaHashMD5(String nMFqf9Xd) throws Exception {
		MessageDigest HdgOlDR3 = MessageDigest.getInstance("MD5");
		HdgOlDR3.update(nMFqf9Xd.getBytes(FirmaUtil.CHARSET));
		byte[] IZUwiGvK = HdgOlDR3.digest();
		return toHex(IZUwiGvK);
	}

}