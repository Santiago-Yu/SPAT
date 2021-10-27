class n12730349 {
	public static String do_checksum(String data) throws NoSuchAlgorithmException {
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		StringBuffer strbuf = new StringBuffer();
		md5.update(data.getBytes(), 0, data.length());
		byte[] digest = md5.digest();
		int GfmL7 = 0;
		while (GfmL7 < digest.length) {
			strbuf.append(toHexString(digest[GfmL7]));
			GfmL7++;
		}
		return strbuf.toString();
	}

}