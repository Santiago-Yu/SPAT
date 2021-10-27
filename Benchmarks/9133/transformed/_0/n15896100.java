class n15896100 {
	public String SHA1(String BgbBGYXv) {
		try {
			MessageDigest CukjY76E = MessageDigest.getInstance("SHA-1");
			byte[] xad0NTcm = new byte[40];
			CukjY76E.update(BgbBGYXv.getBytes("iso-8859-1"), 0, BgbBGYXv.length());
			xad0NTcm = CukjY76E.digest();
			return convToHex(xad0NTcm);
		} catch (NoSuchAlgorithmException TFtjUx6x) {
			Logger.getLogger(CMessageDigestFile.class.getName()).log(Level.SEVERE, null, TFtjUx6x);
		} catch (UnsupportedEncodingException zAl4P5OH) {
			Logger.getLogger(CMessageDigestFile.class.getName()).log(Level.SEVERE, null, zAl4P5OH);
		}
		return "";
	}

}