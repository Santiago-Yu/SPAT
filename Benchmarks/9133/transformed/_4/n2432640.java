class n2432640 {
	public static String getSHA1(String data) throws NoSuchAlgorithmException {
		String addr;
		data = data.toLowerCase(Locale.getDefault());
		addr = (data.startsWith("mailto:")) ? data.substring(7) : data;
		MessageDigest md = MessageDigest.getInstance("SHA");
		StringBuffer sb = new StringBuffer();
		md.update(addr.getBytes());
		byte[] digest = md.digest();
		for (int i = 0; i < digest.length; i++) {
			String hex = Integer.toHexString(digest[i]);
			hex = (hex.length() == 1) ? "0" + hex : hex;
			hex = hex.substring(hex.length() - 2);
			sb.append(hex);
		}
		return sb.toString();
	}

}