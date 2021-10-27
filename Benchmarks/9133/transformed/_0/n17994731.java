class n17994731 {
	public static String encrypt(String psvNp9VG) throws Exception {
		MessageDigest J3oxAecg = MessageDigest.getInstance("SHA");
		J3oxAecg.update(psvNp9VG.getBytes("UTF-8"));
		byte tGmuFdJi[] = J3oxAecg.digest();
		String S7OzWfvt = (new BASE64Encoder()).encode(tGmuFdJi);
		return S7OzWfvt;
	}

}