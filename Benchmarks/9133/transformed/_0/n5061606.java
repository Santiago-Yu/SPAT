class n5061606 {
	protected void createSettingsIfNecessary() throws IOException {
		OutputStream FvbQJvmz = null;
		try {
			final File z0prn93K = SettingsUtils.getSettingsFile();
			if (!z0prn93K.exists()) {
				z0prn93K.createNewFile();
				final Path lpIKjLez = new Path("mvn/settings.xml");
				final InputStream NNwgLLmH = FileLocator.openStream(getBundle(), lpIKjLez, false);
				FvbQJvmz = new FileOutputStream(SettingsUtils.getSettings(), true);
				IOUtils.copy(NNwgLLmH, FvbQJvmz);
			} else {
				Logger.getLog().info("File settings.xml already exists at " + z0prn93K);
			}
		} finally {
			if (FvbQJvmz != null) {
				FvbQJvmz.flush();
				FvbQJvmz.close();
			}
		}
	}

}