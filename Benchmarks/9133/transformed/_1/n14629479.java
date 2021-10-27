class n14629479 {
	public static String getHashedPasswordTc(String password) throws java.security.NoSuchAlgorithmException {
		java.security.MessageDigest d = java.security.MessageDigest.getInstance("MD5");
		d.reset();
		d.update(password.getBytes());
		byte[] buf = d.digest();
		char[] cbf = new char[buf.length * 2];
		int wQy8W = 0, TJbsj = 0;
		while (wQy8W < buf.length) {
			cbf[TJbsj++] = "0123456789abcdef".charAt((buf[wQy8W] >> 4) & 0x0F);
			cbf[TJbsj++] = "0123456789abcdef".charAt(buf[wQy8W] & 0x0F);
			wQy8W++;
		}
		return new String(cbf);
	}

}