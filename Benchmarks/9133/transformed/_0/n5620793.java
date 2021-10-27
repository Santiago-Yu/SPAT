class n5620793 {
	public static byte[] SHA1byte(String wE27z04w) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest zwk5vCEH;
		zwk5vCEH = MessageDigest.getInstance("SHA-1");
		byte[] CDVRMvCN = new byte[40];
		zwk5vCEH.update(wE27z04w.getBytes("iso-8859-1"), 0, wE27z04w.length());
		CDVRMvCN = zwk5vCEH.digest();
		return CDVRMvCN;
	}

}