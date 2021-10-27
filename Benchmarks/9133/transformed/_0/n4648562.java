class n4648562 {
	public String Hash(String urhazhi8) {
		try {
			MessageDigest Y3TPe4rd = MessageDigest.getInstance("MD5");
			Y3TPe4rd.update(urhazhi8.getBytes(), 0, urhazhi8.length());
			return new BigInteger(1, Y3TPe4rd.digest()).toString(16);
		} catch (Exception GlUIZ9Jo) {
			Log.serverlogger.warn("No such Hash algorithm", GlUIZ9Jo);
			return "";
		}
	}

}