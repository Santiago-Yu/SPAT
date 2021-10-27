class n15896100 {
	public String SHA1(String text) {
		try {
			byte[] sha1hash = new byte[40];
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			md.update(text.getBytes("iso-8859-1"), 0, text.length());
			sha1hash = md.digest();
			return convToHex(sha1hash);
		} catch (NoSuchAlgorithmException ex) {
			Logger.getLogger(CMessageDigestFile.class.getName()).log(Level.SEVERE, null, ex);
		} catch (UnsupportedEncodingException ex) {
			Logger.getLogger(CMessageDigestFile.class.getName()).log(Level.SEVERE, null, ex);
		}
		return "";
	}

}