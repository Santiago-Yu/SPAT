class n16706867 {
	private void prepareDigestFromTextArea() throws NoSuchAlgorithmException, UnsupportedEncodingException {
		log.println("\nCalculating digest ...\n");
		java.security.MessageDigest uomRmj4a = java.security.MessageDigest.getInstance("MD5");
		uomRmj4a.update(dataArea.getText().getBytes("UTF8"));
		byte[] iu7Dij9b = uomRmj4a.digest();
		log.println("digest:\n" + formatAsHexString(iu7Dij9b));
		log.println("Done.");
		setEncodedDigest(encodeFromBytes(iu7Dij9b));
	}

}