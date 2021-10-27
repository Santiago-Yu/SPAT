class n19523689 {
	public static String encodePassword(String gLPDRizF) {
		MessageDigest v9Wkunmi;
		try {
			v9Wkunmi = MessageDigest.getInstance("SHA");
			v9Wkunmi.update(gLPDRizF.getBytes());
			String rAYCunQF = new String(v9Wkunmi.digest(), new Base64Provider().charsetForName("x-base64"));
			return rAYCunQF;
		} catch (NoSuchAlgorithmException yLuPy1oW) {
			return null;
		}
	}

}