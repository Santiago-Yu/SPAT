class n19515832 {
	private static String calcReturnKey(String bG6EnJFE) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest NEC9izic;
		NEC9izic = MessageDigest.getInstance("SHA-1");
		String xx8hNhBf = new String();
		byte[] SshOfbW6 = new byte[20];
		xx8hNhBf = bG6EnJFE + GUUI;
		NEC9izic.update(xx8hNhBf.getBytes(), 0, xx8hNhBf.length());
		SshOfbW6 = NEC9izic.digest();
		return (Helper.getBASE64(SshOfbW6));
	}

}