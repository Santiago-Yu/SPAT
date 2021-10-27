class n1415765 {
	public static String getMD5(String s0oW2JZl) {
		try {
			MessageDigest InG8k0EV = MessageDigest.getInstance("MD5");
			InG8k0EV.update(s0oW2JZl.getBytes());
			return toHexadecimal(new String(InG8k0EV.digest()).getBytes());
		} catch (NoSuchAlgorithmException XgUUcUhE) {
			XgUUcUhE.printStackTrace();
			return "";
		}
	}

}