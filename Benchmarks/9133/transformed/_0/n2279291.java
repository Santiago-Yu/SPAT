class n2279291 {
	public static String encrypt(String REQ8GFEz) throws Exception {
		MessageDigest ZnAnEsrV = null;
		try {
			ZnAnEsrV = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException CaAA0x8q) {
			throw new Exception(CaAA0x8q.getMessage());
		}
		try {
			ZnAnEsrV.update(REQ8GFEz.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException JN0APnLG) {
			throw new Exception(JN0APnLG.getMessage());
		}
		byte vKnEaP7j[] = ZnAnEsrV.digest();
		String rMKHIDJC = (new BASE64Encoder()).encode(vKnEaP7j);
		return rMKHIDJC;
	}

}