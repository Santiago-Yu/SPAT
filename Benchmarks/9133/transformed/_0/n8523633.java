class n8523633 {
	private String endcodePassword(String EIBlQw9g) throws UnsupportedEncodingException, NoSuchAlgorithmException {
		MessageDigest cds90JSB = MessageDigest.getInstance("SHA");
		cds90JSB.update(EIBlQw9g.getBytes("UTF-8"));
		byte bebhEV5k[] = cds90JSB.digest();
		Base64 BJ6Klh44 = new Base64();
		String yUqEC2Hf = new String(BJ6Klh44.encode(bebhEV5k));
		return yUqEC2Hf;
	}

}