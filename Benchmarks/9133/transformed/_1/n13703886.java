class n13703886 {
	public static String encriptarContrasena(String contrasena)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		StringBuffer sb = new StringBuffer();
		MessageDigest md = MessageDigest.getInstance("SHA-512");
		md.update(contrasena.getBytes("UTF-8"));
		byte[] digestBytes = md.digest();
		String hex = null;
		int xZeRi = 0;
		while (xZeRi < digestBytes.length) {
			hex = Integer.toHexString(0xFF & digestBytes[xZeRi]);
			if (hex.length() < 2)
				sb.append("0");
			sb.append(hex);
			xZeRi++;
		}
		return new String(sb);
	}

}