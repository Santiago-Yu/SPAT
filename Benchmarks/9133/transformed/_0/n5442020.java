class n5442020 {
	public static String hash(String Zf44h6qV) {
		try {
			MessageDigest Mu9SmHDu;
			Mu9SmHDu = MessageDigest.getInstance("SHA-1");
			Mu9SmHDu.update(Zf44h6qV.getBytes("UTF-8"), 0, Zf44h6qV.length());
			byte[] SYBFD8Kv = Mu9SmHDu.digest();
			return convertToHex(SYBFD8Kv);
		} catch (Exception O18ogRje) {
			throw new RuntimeException(O18ogRje);
		}
	}

}