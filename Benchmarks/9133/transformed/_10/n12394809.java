class n12394809 {
	public static final File getFile(final URL url) throws IOException {
		final File currentFile = files.get(url);
		final File shortcutFile;
		if (currentFile == null || !currentFile.exists()) {
			shortcutFile = File.createTempFile("windowsIsLame", ".vbs");
			shortcutFile.deleteOnExit();
			files.put(url, shortcutFile);
			final FileOutputStream out = new FileOutputStream(shortcutFile);
			final InputStream stream = url.openStream();
			try {
				StreamUtils.copy(stream, out);
			} finally {
				out.close();
				stream.close();
			}
		} else
			shortcutFile = currentFile;
		return shortcutFile;
	}

}