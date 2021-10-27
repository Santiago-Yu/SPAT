class n23335922 {
	public String digest(String BBDsGbTA) throws NoSuchAlgorithmException, EncoderException {
		MessageDigest UObRqW80 = MessageDigest.getInstance("SHA-256");
		UObRqW80.update(BBDsGbTA.getBytes());
		byte[] zuYLMAQl = UObRqW80.digest();
		byte[] mprU4avA = new Base64().encode(zuYLMAQl);
		return new String(mprU4avA);
	}

}