class n16714944 {
	public static String MD5(String text) throws ProducteevSignatureException {
		try {
			MessageDigest md;
			byte[] md5hash;
			md = MessageDigest.getInstance(ALGORITHM);
			md.update(text.getBytes("utf-8"), 0, text.length());
			md5hash = md.digest();
			return convertToHex(md5hash);
		} catch (NoSuchAlgorithmException nsae) {
			throw new ProducteevSignatureException("No such algorithm : " + ALGORITHM, nsae);
		} catch (UnsupportedEncodingException e) {
			throw new ProducteevSignatureException("No such algorithm : " + ALGORITHM, e);
		}
	}

}