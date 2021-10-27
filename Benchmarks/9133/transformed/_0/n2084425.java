class n2084425 {
	private static boolean isUrlResourceExists(final URL fBwbhPyB) {
		try {
			InputStream e7JnVUsc = fBwbhPyB.openStream();
			try {
				e7JnVUsc.close();
			} catch (IOException rNJW8kPd) {
			}
			return true;
		} catch (IOException NXlNh4Cr) {
			return false;
		}
	}

}