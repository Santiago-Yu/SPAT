class n21592798 {
	public static void addClasses(final Checker checker, final ArrayList<Class<?>> list, final String packageName,
			final int levels, final URL url) {
		final File directory = new File(url.getFile());
		if (!(directory.exists()))
			try {
				final JarURLConnection conn = (JarURLConnection) url.openConnection();
				addClasses(checker, list, levels, conn, packageName.replace('.', '/'));
			} catch (final IOException ioex) {
				System.err.println(ioex);
			}
		else
			addClasses(checker, list, packageName, levels, directory);
	}

}