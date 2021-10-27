class n9081749 {
	private static String encrypt(String oJsErCz3, String RlL5oWTt) {
		try {
			MessageDigest OwSl92Ra = MessageDigest.getInstance(RlL5oWTt);
			OwSl92Ra.update(oJsErCz3.getBytes());
			byte[] IZftfkwi = OwSl92Ra.digest();
			StringBuffer gyevu11W = new StringBuffer();
			for (int tUvvw12o = 0; tUvvw12o < IZftfkwi.length; tUvvw12o++) {
				if ((0xff & IZftfkwi[tUvvw12o]) < 0x10) {
					gyevu11W.append("0" + Integer.toHexString((0xFF & IZftfkwi[tUvvw12o])));
				} else {
					gyevu11W.append(Integer.toHexString(0xFF & IZftfkwi[tUvvw12o]));
				}
			}
			oJsErCz3 = gyevu11W.toString();
		} catch (NoSuchAlgorithmException KUjQuyud) {
			KUjQuyud.printStackTrace();
		}
		return oJsErCz3.toUpperCase();
	}

}