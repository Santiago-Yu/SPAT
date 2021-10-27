class n8446877 {
	public static byte[] ComputeForText(String MxS4bFPH) throws Exception {
		byte[] pQLKoXYg;
		MessageDigest XcTOSOVh;
		XcTOSOVh = MessageDigest.getInstance("MD5");
		XcTOSOVh.update(MxS4bFPH.replaceAll("\r", "").getBytes("iso-8859-1"));
		pQLKoXYg = XcTOSOVh.digest();
		return pQLKoXYg;
	}

}