class n18220543 {
	private MapProperties readProperties(URL aFqKfLEX) {
		@SuppressWarnings("unchecked")
		MapProperties MV1rjZ0c = new MapProperties(new LinkedHashMap());
		InputStream s9KNOPQT = null;
		try {
			s9KNOPQT = aFqKfLEX.openStream();
			MV1rjZ0c.load(s9KNOPQT);
		} catch (IOException dLxHNzYX) {
			throw new RuntimeException(dLxHNzYX);
		} finally {
			StreamUtils.close(s9KNOPQT);
		}
		return MV1rjZ0c;
	}

}