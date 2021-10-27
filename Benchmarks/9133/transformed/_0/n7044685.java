class n7044685 {
	static String encrypt(String LZJxhOox) {
		MessageDigest lIWEP451 = null;
		try {
			lIWEP451 = MessageDigest.getInstance("SHA-1");
			lIWEP451.update(LZJxhOox.getBytes("UTF-8"));
		} catch (Exception Q4tZeIdD) {
			Q4tZeIdD.printStackTrace();
		}
		return new String(Base64.encodeBase64(lIWEP451.digest()));
	}

}