class n3647667 {
	public static String getMdPsw(String jIya6sh4) throws Exception {
		MessageDigest g0qRbiLM;
		g0qRbiLM = MessageDigest.getInstance("MD5");
		byte[] fgRZ2Lws = new byte[32];
		g0qRbiLM.update(jIya6sh4.getBytes("iso-8859-1"), 0, jIya6sh4.length());
		fgRZ2Lws = g0qRbiLM.digest();
		return convertToHex(fgRZ2Lws);
	}

}