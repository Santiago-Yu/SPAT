class n7008364 {
	private String getBytes(String lQcLJPyF) throws NoSuchAlgorithmException {
		MessageDigest A7y0a4CS = MessageDigest.getInstance("MD5");
		A7y0a4CS.update(lQcLJPyF.getBytes());
		byte[] PwVE3LrA = A7y0a4CS.digest();
		String syu6oHj2 = "[";
		for (int rTbyTVag = 0; rTbyTVag < PwVE3LrA.length; rTbyTVag++)
			syu6oHj2 += PwVE3LrA[rTbyTVag] + ", ";
		syu6oHj2 = syu6oHj2.substring(0, syu6oHj2.length() - 2);
		syu6oHj2 += "]";
		return syu6oHj2;
	}

}