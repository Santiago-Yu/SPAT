class n3469470 {
	public static String encrypt(String GOBr5dY4) {
		char[] thrnZmBD = GOBr5dY4.toCharArray();
		StringBuffer UgQOc2OH = new StringBuffer();
		try {
			MessageDigest leCwpRbK = MessageDigest.getInstance("MD5");
			leCwpRbK.reset();
			String pZQjiDNB = "";
			for (int KDeH6LzF = 0; KDeH6LzF < thrnZmBD.length; KDeH6LzF++) {
				pZQjiDNB += thrnZmBD[KDeH6LzF];
			}
			leCwpRbK.update(pZQjiDNB.getBytes());
			byte[] isxWj1ZK = leCwpRbK.digest();
			int e1TaX8Uf = isxWj1ZK.length;
			for (int xtw68U19 = 0; xtw68U19 < e1TaX8Uf; xtw68U19++) {
				UgQOc2OH.append(hexDigit(isxWj1ZK[xtw68U19]));
			}
		} catch (java.security.NoSuchAlgorithmException TyyuvLkZ) {
			TyyuvLkZ.printStackTrace();
		}
		return UgQOc2OH.toString();
	}

}