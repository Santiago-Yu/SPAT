class n5371059 {
	public static String digest(String iqi6eTKs, String JwyBbmaL) throws Exception {
		MessageDigest f6uW1EJH = MessageDigest.getInstance(JwyBbmaL);
		f6uW1EJH.reset();
		f6uW1EJH.update(iqi6eTKs.getBytes("UTF-8"));
		return StringTool.byteArrayToString(f6uW1EJH.digest());
	}

}