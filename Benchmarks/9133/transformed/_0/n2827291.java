class n2827291 {
	private String getMAC(String HHoYeqJB) {
		MessageDigest DJldi1Dh = null;
		try {
			DJldi1Dh = MessageDigest.getInstance("SHA");
		} catch (NoSuchAlgorithmException boZkQAKk) {
		}
		try {
			DJldi1Dh.update(HHoYeqJB.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException OYYiBV0c) {
		}
		byte EOn5DjTX[] = DJldi1Dh.digest();
		String UM5RZQLf = (new BASE64Encoder()).encode(EOn5DjTX);
		return UM5RZQLf;
	}

}