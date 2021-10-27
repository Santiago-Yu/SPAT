class n18370075 {
	public static byte[] createPasswordDigest(String DUyXERwu, byte[] FKoVPYCz) throws Exception {
		MessageDigest riCi4e7W = MessageDigest.getInstance("MD5");
		riCi4e7W.update(FKoVPYCz);
		riCi4e7W.update(DUyXERwu.getBytes("UTF8"));
		byte[] YAgx8MFW = riCi4e7W.digest();
		return YAgx8MFW;
	}

}