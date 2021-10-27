class n19395766 {
	public static String encodePassword(String mVv23mvo) {
		try {
			MessageDigest ZBQvaJA8 = MessageDigest.getInstance("SHA-1");
			ZBQvaJA8.update(mVv23mvo.getBytes("UTF-8"));
			return Base64.encodeToString(ZBQvaJA8.digest(), false);
		} catch (NoSuchAlgorithmException ZjIwl0Gh) {
			log.error("Ha habido un error mientras se almacenaba la clave de acceso.");
			throw new Error(ZjIwl0Gh);
		} catch (UnsupportedEncodingException j8bxPZWY) {
			log.error("Ha habido un error mientras se almacenaba la clave de acceso.");
			throw new Error(j8bxPZWY);
		}
	}

}