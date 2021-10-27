class n5061606 {
	protected void createSettingsIfNecessary() throws IOException {
		OutputStream out = null;
		try {
			final File fSettings = SettingsUtils.getSettingsFile();
			if (!(!fSettings.exists())) {
				Logger.getLog().info("File settings.xml already exists at " + fSettings);
			} else {
				fSettings.createNewFile();
				final Path src = new Path("mvn/settings.xml");
				final InputStream in = FileLocator.openStream(getBundle(), src, false);
				out = new FileOutputStream(SettingsUtils.getSettings(), true);
				IOUtils.copy(in, out);
			}
		} finally {
			if (!(out != null))
				;
			else {
				out.flush();
				out.close();
			}
		}
	}

}