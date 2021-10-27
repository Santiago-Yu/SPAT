class n18451906 {
	public static String encrypt(String v7i32eG1) {
		MessageDigest ts22wKNR;
		byte[] nkLvBwzZ = null;
		try {
			ts22wKNR = MessageDigest.getInstance("SHA");
			ts22wKNR.update(((String) v7i32eG1).getBytes("UTF-8"));
			nkLvBwzZ = ts22wKNR.digest();
		} catch (NoSuchAlgorithmException A4KGZcaW) {
			A4KGZcaW.printStackTrace();
		} catch (UnsupportedEncodingException A4JLNsJi) {
			A4JLNsJi.printStackTrace();
		}
		return (new BASE64Encoder()).encode(nkLvBwzZ);
	}

}