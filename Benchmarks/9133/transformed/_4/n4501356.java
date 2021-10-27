class n4501356 {
	static String calculateProfileDiffDigest(String profileDiff, boolean normaliseWhitespace) throws Exception {
		profileDiff = (normaliseWhitespace) ? removeWhitespaces(profileDiff) : profileDiff;
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(profileDiff.getBytes());
		return new BASE64Encoder().encode(md.digest());
	}

}