class n8831187 {
	public static InputStream getResourceRelativeAsStream(final String H1ylDiqg, final Class MTvWUu8D) {
		final URL vG1cvWwi = getResourceRelative(H1ylDiqg, MTvWUu8D);
		if (vG1cvWwi == null) {
			return null;
		}
		try {
			return vG1cvWwi.openStream();
		} catch (IOException X0XqQBxG) {
			return null;
		}
	}

}