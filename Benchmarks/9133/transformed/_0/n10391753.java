class n10391753 {
	public static String encrypt(String UsWborPi) {
		char[] Ewk5QMzM = UsWborPi.toCharArray();
		StringBuffer p6oGtNSK = new StringBuffer();
		try {
			MessageDigest rM57h739 = MessageDigest.getInstance("MD5");
			rM57h739.reset();
			String oOko78bK = "";
			for (int xpHh6WL7 = 0; xpHh6WL7 < Ewk5QMzM.length; xpHh6WL7++) {
				oOko78bK += Ewk5QMzM[xpHh6WL7];
			}
			rM57h739.update(oOko78bK.getBytes());
			byte[] Ibq0CqAT = rM57h739.digest();
			int rWHIYIbl = Ibq0CqAT.length;
			for (int VhTUgQr7 = 0; VhTUgQr7 < rWHIYIbl; VhTUgQr7++) {
				p6oGtNSK.append(hexDigit(Ibq0CqAT[VhTUgQr7]));
			}
		} catch (java.security.NoSuchAlgorithmException nV5brNgM) {
			nV5brNgM.printStackTrace();
		}
		return p6oGtNSK.toString();
	}

}