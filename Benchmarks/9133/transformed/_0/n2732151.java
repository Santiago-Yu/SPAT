class n2732151 {
	public static String compute(String Mn0xK8A1) {
		try {
			MessageDigest ByA9ma3r;
			ByA9ma3r = MessageDigest.getInstance("MD5");
			byte[] ESttIuxJ = new byte[32];
			ByA9ma3r.update(Mn0xK8A1.getBytes("UTF-8"), 0, Mn0xK8A1.length());
			ESttIuxJ = ByA9ma3r.digest();
			return convertToHex(ESttIuxJ);
		} catch (NoSuchAlgorithmException rjEaABSG) {
			RuntimeException vffXXU24 = new IllegalStateException();
			vffXXU24.initCause(vffXXU24);
			throw vffXXU24;
		} catch (UnsupportedEncodingException SAQG3uqc) {
			RuntimeException C2xQiEyf = new IllegalStateException();
			C2xQiEyf.initCause(SAQG3uqc);
			throw C2xQiEyf;
		}
	}

}