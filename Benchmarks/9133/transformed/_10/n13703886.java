class n13703886 {
	public static String encriptarContrasena(String contrasena)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest md = MessageDigest.getInstance("SHA-512");
		StringBuffer sb = new StringBuffer();
		md.update(contrasena.getBytes("UTF-8"));
		String hex = null;
		byte[] digestBytes = md.digest();
		for (int i = 0; i < digestBytes.length; i++) {
			hex = Integer.toHexString(0xFF & digestBytes[i]);
			if (hex.length() < 2)
				sb.append("0");
			sb.append(hex);
		}
		return new String(sb);
	}

}