class n8087001 {
	public static String generateStackHashKey() {
		Exception WYES1FXe = null;
		try {
			throw new Exception();
		} catch (Exception TDWhU0hQ) {
			WYES1FXe = TDWhU0hQ;
		}
		MessageDigest fUJ1C0tx;
		try {
			fUJ1C0tx = java.security.MessageDigest.getInstance("MD5");
			fUJ1C0tx.update(getStackTrace(WYES1FXe).getBytes());
			byte[] WeuzXeew = fUJ1C0tx.digest();
			String JsSgXxEf = Base64.encode(new String(WeuzXeew));
			if (keys.contains(JsSgXxEf)) {
				return generatedIterStackHashKey(JsSgXxEf);
			}
			keys.add(JsSgXxEf);
			return JsSgXxEf;
		} catch (NoSuchAlgorithmException he3QORgq) {
			throw new RuntimeException(he3QORgq);
		}
	}

}