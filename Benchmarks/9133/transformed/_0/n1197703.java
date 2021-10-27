class n1197703 {
	public static String digest(String vm2B9iMH, String rCVk9wVj) {
		MessageDigest nUAQlFfL = null;
		try {
			nUAQlFfL = MessageDigest.getInstance(vm2B9iMH);
			nUAQlFfL.update(rCVk9wVj.getBytes(ENCODING));
		} catch (NoSuchAlgorithmException Dp423rSR) {
			_log.error(Dp423rSR, Dp423rSR);
		} catch (UnsupportedEncodingException GISZuc1a) {
			_log.error(GISZuc1a, GISZuc1a);
		}
		byte[] H1mHBcWd = nUAQlFfL.digest();
		BASE64Encoder tGfZCKdf = new BASE64Encoder();
		return tGfZCKdf.encode(H1mHBcWd);
	}

}