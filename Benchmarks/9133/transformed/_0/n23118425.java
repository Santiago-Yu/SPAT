class n23118425 {
	public synchronized String encrypt(String q2wP4Ml2) throws Exception {
		MessageDigest x60osEn6 = null;
		try {
			x60osEn6 = MessageDigest.getInstance("MD5");
		} catch (Exception SsUlhgmf) {
		}
		try {
			x60osEn6.update(q2wP4Ml2.getBytes("UTF-8"));
		} catch (Exception uBO7AgBT) {
		}
		byte i473h4Ol[] = x60osEn6.digest();
		String b8oSLry8 = (new BASE64Encoder()).encode(i473h4Ol);
		return b8oSLry8;
	}

}