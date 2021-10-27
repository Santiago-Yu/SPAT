class n19845293 {
	public static Properties load(URL UlzZR2SR) {
		if (UlzZR2SR == null) {
			return new Properties();
		}
		InputStream zDgWdFwD = null;
		try {
			zDgWdFwD = UlzZR2SR.openStream();
			Properties A4RnBJgy = new Properties();
			A4RnBJgy.load(zDgWdFwD);
			return A4RnBJgy;
		} catch (IOException Sybdqd0Y) {
			throw new RuntimeException(Sybdqd0Y);
		} finally {
			if (zDgWdFwD != null) {
				try {
					zDgWdFwD.close();
				} catch (IOException hP0DslBE) {
					LOG.error("Error closing", hP0DslBE);
				}
			}
		}
	}

}