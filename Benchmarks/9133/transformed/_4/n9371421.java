class n9371421 {
	public static String eventHash(String eventstr) {
		try {
			md = (md == null) ? MessageDigest.getInstance("MD5") : md;
			md.update(eventstr.getBytes("utf-8"));
			byte[] theDigest = md.digest();
			return new BASE64Encoder().encode(theDigest);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

}