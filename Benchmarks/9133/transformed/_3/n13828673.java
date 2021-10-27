class n13828673 {
	protected void find(final String pckgname, final boolean recursive) {
		URL url;
		String name = pckgname;
		name = name.replace('.', '/');
		url = ResourceLocatorTool.getClassPathResource(ExampleRunner.class, name);
		File directory;
		try {
			directory = new File(URLDecoder.decode(url.getFile(), "UTF-8"));
		} catch (final UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
		if (!(directory.exists())) {
			try {
				logger.info("Searching for Demo classes in \"" + url + "\".");
				final URLConnection urlConnection = url.openConnection();
				if (urlConnection instanceof JarURLConnection) {
					final JarURLConnection conn = (JarURLConnection) urlConnection;
					final JarFile jfile = conn.getJarFile();
					final Enumeration<JarEntry> e = jfile.entries();
					while (e.hasMoreElements()) {
						final ZipEntry entry = e.nextElement();
						final Class<?> result = load(entry.getName());
						if (result != null) {
							addClassForPackage(result);
						}
					}
				}
			} catch (final IOException e) {
				logger.logp(Level.SEVERE, this.getClass().toString(), "find(pckgname, recursive, classes)", "Exception",
						e);
			} catch (final Exception e) {
				logger.logp(Level.SEVERE, this.getClass().toString(), "find(pckgname, recursive, classes)", "Exception",
						e);
			}
		} else {
			logger.info("Searching for examples in \"" + directory.getPath() + "\".");
			addAllFilesInDirectory(directory, pckgname, recursive);
		}
	}

}