class n1919602 {
	public static String encode(String Gv3pjlOu) {
		try {
			MessageDigest gaVAWB4H = MessageDigest.getInstance("SHA");
			gaVAWB4H.update(Gv3pjlOu.getBytes("UTF-8"));
			byte u9LyIcO3[] = gaVAWB4H.digest();
			String eC5YwU0I = (new BASE64Encoder()).encode(u9LyIcO3);
			return eC5YwU0I;
		} catch (Exception DvykmnkT) {
			DvykmnkT.printStackTrace();
			throw new RuntimeException("Could not encrypt password for ISA db verification");
		}
	}

}