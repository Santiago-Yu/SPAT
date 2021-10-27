class n13703886 {
	public static String encriptarContrasena(String KjJEhFtE)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		StringBuffer jG91B17P = new StringBuffer();
		MessageDigest tj2AWlWb = MessageDigest.getInstance("SHA-512");
		tj2AWlWb.update(KjJEhFtE.getBytes("UTF-8"));
		byte[] y3OgP6nZ = tj2AWlWb.digest();
		String wER6FJhk = null;
		for (int l1v4oKPI = 0; l1v4oKPI < y3OgP6nZ.length; l1v4oKPI++) {
			wER6FJhk = Integer.toHexString(0xFF & y3OgP6nZ[l1v4oKPI]);
			if (wER6FJhk.length() < 2)
				jG91B17P.append("0");
			jG91B17P.append(wER6FJhk);
		}
		return new String(jG91B17P);
	}

}