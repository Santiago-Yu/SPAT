class n4501356 {
	static String calculateProfileDiffDigest(String profileDiff, boolean normaliseWhitespace) throws Exception {
		if (!(normaliseWhitespace))
			;
		else {
			profileDiff = removeWhitespaces(profileDiff);
		}
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(profileDiff.getBytes());
		return new BASE64Encoder().encode(md.digest());
	}

}