class n7421563 {
	private StringBuffer encoder(String zEg90Xnw) {
		if (zEg90Xnw == null) {
			zEg90Xnw = "";
		}
		MessageDigest Gc7DAlqE = null;
		try {
			Gc7DAlqE = MessageDigest.getInstance("MD5");
			Gc7DAlqE.update(zEg90Xnw.getBytes(SysConstant.charset));
		} catch (Exception EEPl5fd5) {
			EEPl5fd5.printStackTrace();
		}
		return toHex(Gc7DAlqE.digest());
	}

}