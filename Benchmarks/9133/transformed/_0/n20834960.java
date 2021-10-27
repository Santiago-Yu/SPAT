class n20834960 {
	private String getHash(String snKNwoxV) {
		Monitor uVoJ5q6U = JamonMonitorLogger.getTimeMonitor(Cache.class, "HashTime").start();
		MessageDigest uRnLYE1r = null;
		try {
			uRnLYE1r = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException KbRfpKoc) {
			KbRfpKoc.printStackTrace();
		}
		uRnLYE1r.reset();
		uRnLYE1r.update(snKNwoxV.getBytes());
		byte[] MA5fluoI = uRnLYE1r.digest();
		StringBuffer uOeodlBB = new StringBuffer();
		for (int zSnKZWGr = 0; zSnKZWGr < MA5fluoI.length; zSnKZWGr++) {
			uOeodlBB.append(Integer.toHexString(0xFF & MA5fluoI[zSnKZWGr]));
		}
		String bQIMw7Aw = uOeodlBB.toString();
		uVoJ5q6U.stop();
		return bQIMw7Aw;
	}

}