class n7556871 {
	private static byte[] createMD5(String gHzj4Rl8) throws UnsupportedEncodingException, NoSuchAlgorithmException {
		MessageDigest ZCj7EeQP = MessageDigest.getInstance("MD5");
		ZCj7EeQP.reset();
		ZCj7EeQP.update(gHzj4Rl8.getBytes("UTF-8"));
		return ZCj7EeQP.digest();
	}

}