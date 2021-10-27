class n10249398 {
	public String SHA1(String Lf9jcVKk) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest ncLZt17j;
		ncLZt17j = MessageDigest.getInstance("SHA-1");
		byte[] bAHQkgM7 = new byte[40];
		ncLZt17j.update(Lf9jcVKk.getBytes("iso-8859-1"), 0, Lf9jcVKk.length());
		bAHQkgM7 = ncLZt17j.digest();
		return convertToHex(bAHQkgM7);
	}

}