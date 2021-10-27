class n3253205 {
	private String generateUniqueIdMD5(Run gKA44Gdj, HttpServletRequest xga0KKiM, String A4TATqA7) {
		String rt3re7qb = xga0KKiM.getScheme() + "://" + xga0KKiM.getServerName() + ":" + xga0KKiM.getServerPort();
		String mXHZbjnt = rt3re7qb + "run:" + gKA44Gdj.getId().toString() + "group:" + A4TATqA7;
		MessageDigest BiOzGneY = null;
		try {
			BiOzGneY = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException RS1NoWGg) {
			RS1NoWGg.printStackTrace();
		}
		BiOzGneY.update(mXHZbjnt.getBytes(), 0, mXHZbjnt.length());
		String AEqVuNKN = new BigInteger(1, BiOzGneY.digest()).toString(16);
		return AEqVuNKN;
	}

}