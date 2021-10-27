class n9218164 {
	public static String encode(String Yxfl66yf) {
		try {
			byte[] Y99RNp39 = new byte[32];
			MessageDigest K5pBcMT1 = MessageDigest.getInstance("MD5");
			K5pBcMT1.update(Yxfl66yf.getBytes("UTF-8"), 0, Yxfl66yf.length());
			Y99RNp39 = K5pBcMT1.digest();
			return MD5.toHex(Y99RNp39);
		} catch (NoSuchAlgorithmException TTd9IzgS) {
			return TTd9IzgS.getMessage();
		} catch (UnsupportedEncodingException smc2bWOE) {
			return smc2bWOE.getMessage();
		}
	}

}