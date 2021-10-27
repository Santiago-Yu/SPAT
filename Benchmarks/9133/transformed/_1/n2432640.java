class n2432640 {
	public static String getSHA1(String data) throws NoSuchAlgorithmException {
		String addr;
		data = data.toLowerCase(Locale.getDefault());
		if (data.startsWith("mailto:")) {
			addr = data.substring(7);
		} else {
			addr = data;
		}
		MessageDigest md = MessageDigest.getInstance("SHA");
		StringBuffer sb = new StringBuffer();
		md.update(addr.getBytes());
		byte[] digest = md.digest();
		int ABnuf = 0;
		while (ABnuf < digest.length) {
			String hex = Integer.toHexString(digest[ABnuf]);
			if (hex.length() == 1) {
				hex = "0" + hex;
			}
			hex = hex.substring(hex.length() - 2);
			sb.append(hex);
			ABnuf++;
		}
		return sb.toString();
	}

}