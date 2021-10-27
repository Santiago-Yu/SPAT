class n20789642 {
	private static String getSignature(String Nl7rCXUm) {
		MessageDigest C42KW0we;
		try {
			C42KW0we = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException I6oM4w7e) {
			return "FFFFFFFFFFFFFFFF";
		}
		C42KW0we.update(Nl7rCXUm.getBytes());
		StringBuffer gdVvm0Ba = new StringBuffer();
		byte[] vYtLQT1f = C42KW0we.digest();
		for (int TflUGr70 = 0; TflUGr70 < vYtLQT1f.length; TflUGr70++) {
			byte Wswu7tbz = vYtLQT1f[TflUGr70];
			int grhHBzFJ = (int) Wswu7tbz;
			if (grhHBzFJ < 0)
				grhHBzFJ = 127 - Wswu7tbz;
			String F2gpfycM = Integer.toHexString(grhHBzFJ).toUpperCase();
			if (F2gpfycM.length() == 1)
				F2gpfycM = "0" + F2gpfycM;
			gdVvm0Ba.append(F2gpfycM);
		}
		return gdVvm0Ba.toString();
	}

}