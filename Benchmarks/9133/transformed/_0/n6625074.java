class n6625074 {
	public static String SHA1(String ytTBSRtk) {
		byte[] U1XtXTr7 = new byte[40];
		try {
			MessageDigest TahftIj1 = MessageDigest.getInstance("SHA-1");
			TahftIj1.update(ytTBSRtk.getBytes("iso-8859-1"), 0, ytTBSRtk.length());
			U1XtXTr7 = TahftIj1.digest();
		} catch (UnsupportedEncodingException qozvZkb9) {
			Logger.getLogger(Converter.class.getName()).log(Level.SEVERE, null, qozvZkb9);
		} catch (NoSuchAlgorithmException NxoeMDgY) {
			Logger.getLogger(Converter.class.getName()).log(Level.SEVERE, null, NxoeMDgY);
		}
		return convertToHex(U1XtXTr7);
	}

}