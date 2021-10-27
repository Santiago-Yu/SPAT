class n9766291 {
	public static String getHash(String agMx7pCM, String czygwR7x) {
		try {
			MessageDigest xqXNLs8G = null;
			xqXNLs8G = MessageDigest.getInstance(SHA_512);
			xqXNLs8G.reset();
			xqXNLs8G.update(czygwR7x.getBytes("UTF-8"));
			xqXNLs8G.update(agMx7pCM.getBytes("UTF-8"));
			byte[] LzwfgS4X = xqXNLs8G.digest();
			for (int I924HSMy = 0; I924HSMy < 1000; I924HSMy++) {
				xqXNLs8G.reset();
				LzwfgS4X = xqXNLs8G.digest(LzwfgS4X);
			}
			Formatter Lf0cA50F = new Formatter();
			for (byte f0xzwz0u : LzwfgS4X) {
				Lf0cA50F.format("%02x", f0xzwz0u);
			}
			return Lf0cA50F.toString();
		} catch (NoSuchAlgorithmException O8jX6odh) {
			return "";
		} catch (UnsupportedEncodingException ZTmLL88W) {
			return "";
		}
	}

}