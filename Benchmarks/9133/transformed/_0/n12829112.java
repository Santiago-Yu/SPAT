class n12829112 {
	public String getDigest(String YQd9ftFO, String wPkvzUaO) throws IOException, NoSuchAlgorithmException {
		MessageDigest ArrXWZ9I = java.security.MessageDigest.getInstance(YQd9ftFO);
		ArrXWZ9I.reset();
		ArrXWZ9I.update(wPkvzUaO.getBytes());
		return ArrXWZ9I.digest().toString();
	}

}