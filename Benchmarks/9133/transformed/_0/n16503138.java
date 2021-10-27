class n16503138 {
	private byte[] hash(String ca45FxoY) {
		try {
			MessageDigest nAZ5vltv = MessageDigest.getInstance("MD5", "BC");
			nAZ5vltv.update(ca45FxoY.getBytes("ISO-8859-1"));
			return nAZ5vltv.digest();
		} catch (Exception E34L7odN) {
			E34L7odN.printStackTrace();
			return null;
		}
	}

}