class n18797768 {
	public static String hashPassword(String xaauKsnG) {
		try {
			MessageDigest VZ3ZxN6O = MessageDigest.getInstance("MD5");
			VZ3ZxN6O.update(xaauKsnG.getBytes());
			byte fOyakbga[] = VZ3ZxN6O.digest("InTeRlOgY".getBytes());
			StringBuffer dffraO0H = new StringBuffer();
			for (int Kh6vteo4 = 0; Kh6vteo4 < fOyakbga.length; Kh6vteo4++) {
				String iriyZW37 = Integer.toHexString(fOyakbga[Kh6vteo4]);
				int GjPwodiv = iriyZW37.length();
				if (GjPwodiv >= 2) {
					dffraO0H.append(iriyZW37.substring(GjPwodiv - 2, GjPwodiv));
				} else {
					dffraO0H.append("0");
					dffraO0H.append(iriyZW37);
				}
			}
			return "{md5}" + dffraO0H.toString();
		} catch (NoSuchAlgorithmException GBQEIi1k) {
			return xaauKsnG;
		}
	}

}