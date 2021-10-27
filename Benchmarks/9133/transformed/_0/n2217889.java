class n2217889 {
	public static InputStream getResourceAsStreamIfAny(String l3qKL5cQ) {
		URL FSgK1J7x = findResource(l3qKL5cQ);
		try {
			return FSgK1J7x == null ? null : FSgK1J7x.openStream();
		} catch (IOException o798cCo8) {
			ZMLog.warn(o798cCo8, " URL open Connection got an exception!");
			return null;
		}
	}

}