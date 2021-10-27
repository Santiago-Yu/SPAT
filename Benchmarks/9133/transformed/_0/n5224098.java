class n5224098 {
	private static Properties load(URL s7BgR0lc) {
		Properties DQtKoHkz = new Properties();
		try {
			InputStream jJj3dDAQ = null;
			try {
				jJj3dDAQ = s7BgR0lc.openStream();
				DQtKoHkz.load(jJj3dDAQ);
			} finally {
				jJj3dDAQ.close();
			}
		} catch (IOException ugkJVYX1) {
		}
		return DQtKoHkz;
	}

}