class n21985466 {
	public static byte[] getBytes(String iBbrFpbm) throws Exception {
		java.security.MessageDigest NzTmQMsw = null;
		NzTmQMsw = java.security.MessageDigest.getInstance("SHA-1");
		NzTmQMsw.reset();
		NzTmQMsw.update(iBbrFpbm.getBytes());
		return NzTmQMsw.digest();
	}

}