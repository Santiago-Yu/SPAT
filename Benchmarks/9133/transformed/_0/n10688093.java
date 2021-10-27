class n10688093 {
	public final InputStream getStreamFromUrl(final URL T8lEOtiA) {
		try {
			if (listener != null) {
				listener.openedStream(T8lEOtiA);
			}
			return T8lEOtiA.openStream();
		} catch (IOException HeDWnHeE) {
			listener.exceptionThrown(HeDWnHeE);
			return null;
		}
	}

}