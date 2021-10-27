class n21994644 {
	public synchronized String encrypt(String tLhMKa52) {
		if (tLhMKa52 == null || tLhMKa52.equals("")) {
			return tLhMKa52;
		}
		String TfsFkREG = null;
		MessageDigest AeONxtVc = null;
		try {
			AeONxtVc = MessageDigest.getInstance("SHA");
		} catch (NoSuchAlgorithmException SXdgab0j) {
			throw new RuntimeException(SXdgab0j.getMessage());
		}
		try {
			AeONxtVc.update(tLhMKa52.getBytes("UTF-8"));
			byte hL4UDScU[] = AeONxtVc.digest();
			TfsFkREG = Base64.encodeBase64String(hL4UDScU).replaceAll("\r\n", "");
		} catch (UnsupportedEncodingException Qbym0hXH) {
			throw new RuntimeException(Qbym0hXH.getMessage());
		}
		return TfsFkREG;
	}

}